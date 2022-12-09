package view;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javafx.fxml.FXMLLoader;
import java.io.FileInputStream;
import java.io.IOException;
import objects.Users;
import objects.Users_List;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUpController {
	
	private Stage primaryStage;
	private Scene myScene;
	private LoginController2 controllerLogin;
	
	
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
			VBox root = loader.load(new FileInputStream("src/view/Login Page.fxml"));
			root.setStyle("-fx-background-color: #ADD8E6;");
			Scene scene = new Scene(root, 900,900);

			
			controllerLogin = loader.getController();
			primaryStage.setMaximized(true);
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

		userList.getUserListFromTxt("src\\\\\\\\objects\\\\\\\\AllUsersTXTFILE");
 		if (userList.newUserGood(email)) {
 			Users newUser= new Users(name, phone, password, email);
 	    	userList.addUser(newUser);
 			try {
          
 	 			userList.saveUserListAsTxt("src\\\\\\\\objects\\\\\\\\AllUsersTXTFILE");
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
 				 
 				
 				controllerLogin = loader.getController();
 				controllerLogin.setPrimaryStage(primaryStage);
 				controllerLogin.setMyScene(scene); 
 				controllerLogin.setUserList(userList);
 				controllerLogin.wrongLoginLabel.setTextFill(Color.LIME);
 				controllerLogin.wrongLoginLabel.setText("Account Created Successful");
 				} 
 	    	catch(Exception e) {
 	    		e.printStackTrace();
 	    	}
 			controllerLogin.takeFocus();
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
