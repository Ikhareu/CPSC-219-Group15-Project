package view;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javafx.fxml.FXMLLoader;

import java.io.FileInputStream;
import java.io.IOException;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * The SignUpController is the controller responsible for the registration page of the program as well as handling
 * the actual registration process through the use of getter and setter methods.
 * The registration page contains 5 textfields 4 for each piece of user data (name, email, phone and password) 
 * which will be used to create a new user object representing the person registering, and 1 confirmation field 
 * for the password.
 * The controller has it's own getter and setter methods for User_List class objects which it uses to both verify
 * that duplicate accounts are not being created (by searching the user list array for occurrences of the same email)
 * and to update the Users_List instance to contain any new accounts it may have added.
*/
public class SignUpController {
	
	private Stage primaryStage;
	private Scene myScene;
	private LoginController2 controllerLogin;
	private SignUpController controllerOne;
	private UserHomepageController controllerTwo;
	
	
	
	
    @FXML
    private TextField passwordTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField emailTextField;


    @FXML
    private Button signUpButton;
    
    @FXML
    private TextField phoneNumberTXT; 

    @FXML
    private TextField nameTXT; 
    @FXML
    private Label signUpLabel;
    
    
    
    
    public Users_List userList = new Users_List();
	
	
	
	public Users_List getUserList() {
		return(userList);
	}
    
	public void setUserList(Users_List uList) {
		userList= uList;
		
	}
 
    
    @FXML
    void cancelAction(ActionEvent event) {
    	
 		try {
 			
	    	FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(new FileInputStream("src/view/Login Page.fxml")); root.setStyle("-fx-background-color: #ADD8E6;");
			Scene scene = new Scene(root,900,900); scene.setFill(Color.BLUE); 
			
			controllerLogin = loader.getController();
			controllerLogin.setPrimaryStage(primaryStage);
			controllerLogin.setMyScene(scene); 
			//controllerLogin.setNextController(this);  
			controllerLogin.setUserList(userList); 
			 
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	} 
 		controllerLogin.takeFocus();
    }

    @FXML
    void signUpAction(ActionEvent event) throws IOException {
    	
    	String email=emailTextField.getText();
    	String password=passwordTextField.getText();
    	String phone= phoneNumberTXT.getText(); 
    	String name=nameTXT.getText();

		userList.getUserListFromTxt("src\\\\objects\\\\AllUsersTXTFILE");
 		if (userList.newUserGood(email)) {
 			Users newUser= new Users(name, phone, password, email);
 	    	userList.addUser(newUser);
 			try {
 	 			userList.saveUserListAsTxt("src\\\\objects\\\\AllUsersTXTFILE");
 		    	FXMLLoader loader = new FXMLLoader();
 				VBox root = loader.load(new FileInputStream("src/view/UserHomepage.fxml")); root.setStyle("-fx-background-color: #ADD8E6;");
 				Scene scene = new Scene(root,900,900); scene.setFill(Color.BLUE); 
 				
 				controllerTwo = loader.getController();
 				controllerTwo.setPrimaryStage(primaryStage);
 				controllerTwo.setMyScene(scene);
 				//controllerTwo.setNextController(this);  
 				controllerTwo.setUser(newUser);  
 				controllerTwo.setUserList(userList); 
 				controllerTwo.loginUserSetup(newUser); 
 				 
 				
 	    	} 
 	    	catch(Exception e) {
 	    		e.printStackTrace();
 	    	}
 			controllerTwo.takeFocus();
 		}
 		else {
 			signUpLabel.setText("Account with that email has already been created. Use another email");
 		}

    }
	 
    
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}
	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void takeFocus() { 
		primaryStage.setScene(myScene);
	}
}
