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

		ArrayList <String> coursesToTeach = user.getcoursesToTeach();
		
		if (coursesToTeach.size()==0) {
			Label nothingToTeach= new Label("You have not added any course you can others help with");
			
		}
		else {
			for(String courseTeach: coursesToTeach) {
				HBox container= new HBox();
				Label label= new Label("Course name:");
				TextField courseTeachTxt= new TextField(courseTeach);

				container.getChildren().addAll(label, courseTeachTxt);
				userCoursesTeach.getChildren().add(container);
				
			}
			 
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
		
		if (coursesToLearn.size()==0) {
			Label nothingToLearn= new Label("You have not added any course you need help with");
			
		}
		else {
			for(String courseLearn: coursesToLearn) {
				HBox container= new HBox();
				Label label= new Label("Course name:");
				TextField courseLearnTxt= new TextField(courseLearn);
				 
				container.getChildren().addAll(label, courseLearnTxt);
				userCoursesLearn.getChildren().add(container);
			}
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
		
		
		try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
			Scene scene = new Scene(root, 900, 900);

			controllerTwo = loader.getController();
			controllerTwo.setPrimaryStage(primaryStage);
			controllerTwo.setMyScene(scene);
			controllerTwo.setUser(userList.getUser(1));
			controllerTwo.setUserList(userList);
			controllerTwo.loginUserSetup(userList.getUser(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    
		

}