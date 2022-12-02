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

public class UserHomepageController {
	
	private Stage primaryStage;
	private Scene myScene;
	private LoginController2 controllerLogin;
	private FindPagesController controllerFind;
	private CoursesPageController controllerCourses;

    @FXML
    private ChoiceBox<String> courseChoiceBox;

    @FXML
    private MenuItem editProfileButton;

    @FXML
    private Button checkButton;

    @FXML
    private MenuItem logoutButton;

    @FXML
    private MenuButton nameLabel;
    
    
    
   

    
    @FXML
    void checkAction(ActionEvent event) {

    }

    @FXML
    void editProfileAction(ActionEvent event) {

    }

    @FXML
    void logoutAction(ActionEvent event) {

    }
    
    
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
    
    public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}
	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void setNextController(LoginController2 aController) {
		controllerLogin = aController;
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	
	
	
	@FXML
	void coursepageaction(ActionEvent event) {
		
		try {
	    	FXMLLoader loader = new FXMLLoader();
			VBox homepagePane = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
			Scene scene = new Scene(homepagePane);
			
			controllerCourses = loader.getController();
			controllerCourses.setPrimaryStage(primaryStage);
			controllerCourses.setMyScene(scene);
			controllerCourses.setUser(user); 
			controllerCourses.setUserList(userList); 
			
			
			
			
			
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		controllerCourses.takeFocus();

		

	}
	
	
	
	

}
