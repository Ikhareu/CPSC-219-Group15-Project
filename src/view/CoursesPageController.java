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
			courseTeachTxt.setPromptText("PRMT101");
			coursesTeachAfter.add(courseTeachTxt);

			container.getChildren().addAll(label, courseTeachTxt);
			userCoursesTeach.getChildren().add(container);

		}
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

			courseLearnTxt.setPromptText("PRMT101");
			coursesLearnAfter.add(courseLearnTxt);
			container.getChildren().addAll(label, courseLearnTxt);
			userCoursesLearn.getChildren().add(container);
		}
	}

	 

	
	//-------------------------------------------------------------------------------------------------------------------------------------------------   	
	
	@FXML
    void goHomePage(ActionEvent event) {

		ArrayList<String> coursesToLearnGoHome = new ArrayList<String>();
		ArrayList<String> coursesToTeachGoHome = new ArrayList<String>();
		
		for (TextField courseTeachTXT : coursesTeachAfter) {
			String str = courseTeachTXT.getText();
			if (!str.equals("")) {
				if ((str.length() == 7 || str.length() == 8)) {
					String str1="";
					str.toUpperCase();
					for (int i=0; i<str.length(); i++) {
						if (str.charAt(i)!=' ') str1=str1+str.charAt(i);
					}
					coursesToTeachGoHome.add(str1);
				}
			}
		}	

		for (TextField courseLearnTXT : coursesLearnAfter) {
			String str = courseLearnTXT.getText();
			if (!str.equals("")) {
				if ((str.length() == 7 || str.length() == 8)) {
					String str1="";
					str.toUpperCase();
					for (int i=0; i<str.length(); i++) {
						if (str.charAt(i)!=' ') str1=str1+str.charAt(i);
					}
					coursesToLearnGoHome.add(str1);
				}
			}
		}
		
		
		user.addCourses(coursesToLearnGoHome, coursesToTeachGoHome);
		
		
		try {

	    	userList.saveUserListAsTxt("C:\\\\Users\\\\dadada\\\\git\\\\CPSC-219-Group15-Project\\\\src\\\\objects\\\\AllUsersTXTFILE");
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
			Scene scene = new Scene(root, 900, 900);
			
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