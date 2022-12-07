package view;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.FileInputStream;
import java.util.ArrayList;
import objects.Users;
import objects.Users_List;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoursesPageController {

    private Users user;

    private ArrayList<TextField> coursesLearnAfter= new ArrayList<TextField>();
    private ArrayList<TextField> coursesTeachAfter= new ArrayList<TextField>();
    

    public Users_List userList = new Users_List();
	
	
	
	public Users_List getUserList() {
		return(userList);
	}
    
	public void setUserList(Users_List uList) {
		userList= uList;
		
	}
    
    
    public void setUser(Users usr) {
    	user=usr;
    	
    }
    
    public Users getUser() {
    	
    	return(user);
    }

  //-------------------------------------------------------------------------------------------------------------------------------------------------   	

	private Stage primaryStage;
	private Scene myScene;
	private UserHomepageController controllerTwo;
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}
	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene); 
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------   	
	public void controllerSetUp() {
		
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------   	

  
    @FXML
    private VBox userCoursesTeach;
	
	
    
	public void addUserCoursesTeach() {

		ArrayList<String> coursesToTeach = user.getcoursesToTeach();

		for (int i = 0; i < 10; i++) {
			HBox container = new HBox();
			Label label = new Label("Course name:");
			String courseTeach = "";
			try {
				courseTeach = coursesToTeach.get(i);
			} catch (Exception e) {

			}
			TextField courseTeachTxt = new TextField(courseTeach);
			coursesTeachAfter.add(courseTeachTxt);

			container.getChildren().addAll(label, courseTeachTxt);
			userCoursesTeach.getChildren().add(container);

		}
	}

	
	@FXML
	void addCoursesTeach(ActionEvent event) {
		HBox container= new HBox();
		Label label= new Label("Course name:");
		TextField courseTeachTxt= new TextField();

		container.getChildren().addAll(label, courseTeachTxt);
		userCoursesTeach.getChildren().add(container);
		
		 

	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------   	


    @FXML
    private VBox userCoursesLearn;
    
    
	public void addUserCoursesLearn() { 

		ArrayList <String> coursesToLearn = user.getcoursesToLearn();
		for(int i=0; i<10; i++) {
			HBox container= new HBox();
			Label label= new Label("Course name:");
			String courseLearn="";
			try {
			courseLearn=coursesToLearn.get(i);
			}
			catch(Exception e) {
				
			}
			
			TextField courseLearnTxt= new TextField(courseLearn);
			
			coursesLearnAfter.add(courseLearnTxt);
			container.getChildren().addAll(label, courseLearnTxt);
			userCoursesLearn.getChildren().add(container);
		}
	}

	 

	@FXML
	void addCoursesLearn(ActionEvent event) {

		HBox container= new HBox();
		Label label= new Label("Course name:");
		TextField courseLearnTxt= new TextField();
		
		container.getChildren().addAll(label, courseLearnTxt);
		userCoursesLearn.getChildren().add(container);
		
		
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------   	
	
	@FXML
    void goHomePage(ActionEvent event) {

		ArrayList<String> coursesToLearnGoHome = new ArrayList<String>();
		ArrayList<String> coursesToTeachGoHome = new ArrayList<String>();
		
		for (TextField courseTeachTXT : coursesTeachAfter) {
			if (courseTeachTXT.getText() != "") {
				coursesToTeachGoHome.add(courseTeachTXT.getText());
			}
		}
		for (TextField courseLearnTXT : coursesLearnAfter) {
			if (courseLearnTXT.getText() != "") {
				coursesToLearnGoHome.add(courseLearnTXT.getText());
			}
		}
		
		user.addCourses(coursesToLearnGoHome, coursesToTeachGoHome);
		System.out.println(user.getcoursesToTeach()+"|||"+user.getcoursesToLearn());
		
		
		try {

	    	userList.saveUserListAsTxt("C:\\\\Users\\\\ohiom\\\\git\\\\AnotherProject\\\\AllUsersTXTFILE.txt");
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
			Scene scene = new Scene(root, 1280, 720);
			
			controllerTwo = loader.getController();
			controllerTwo.setPrimaryStage(primaryStage);
			controllerTwo.setMyScene(scene);
			controllerTwo.setUser(user);
			controllerTwo.setUserList(userList);
			controllerTwo.loginUserSetup(user);

			controllerTwo.takeFocus();  
			

		} catch (Exception e) {
			e.printStackTrace();
		}   
		
	}
    
		

}