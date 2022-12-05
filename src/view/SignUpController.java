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
    private TextField password2TextField;

    @FXML
    private Button signUpButton;
    
    @FXML
    private TextField phoneNumberTXT; 

    @FXML
    private TextField nameTXT; 
    
    
    
    
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
			VBox root = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
			Scene scene = new Scene(root,900,900);
			
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
    void signUpAction(ActionEvent event) {
    	
    	String email=emailTextField.getText();
    	String password=passwordTextField.getText();
    	String phone= phoneNumberTXT.getText(); 
    	String name=nameTXT.getText();
    	
    	Users newUser= new Users(name, phone, password, email);
    	userList.addUser(newUser);
    	
 		try {
 			userList.saveUserListAsTxt("C:\\\\Users\\\\dadada\\\\git\\\\CPSC-219-Group15-Project\\\\src\\\\objects\\\\test");
	    	FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
			Scene scene = new Scene(root,900,900);
			
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
