package view;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import objects.Users;
import objects.Users_List;


public class LoginController2 {

    @FXML
    private TextField loginUsername;

    @FXML
    private Button loginButton;
    
    @FXML
    private Pane mainpaneForTest;

    @FXML
    void testbutton(ActionEvent event) {
    	Label testLabel = new Label("T-----EST----TEST-TEREEREF");
    	mainpaneForTest.getChildren().add(testLabel);
    	
    	
    }

    
    
    @FXML
    private PasswordField loginPassword;

    @FXML
    private Hyperlink createAccountHyperlink;
    
    

	private Stage primaryStage;
	private Scene myScene;
	private SignUpController controllerOne;
	private UserHomepageController controllerTwo;
	

    
    public Users_List userList = new Users_List();
	
	
	
	public Users_List getUserList() {
		return(userList);
	}
    
	public void setUserList(Users_List uList) {
		userList= uList;
		
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

	//-------------------------------------------------------------------------------------------------------------------------------------------------   	
	
	
    @FXML
    void loginAction(ActionEvent event) throws IOException {

    	userList.getUserListFromTxt("C:\\\\Users\\\\dadada\\\\git\\\\CPSC-219-Group15-Project\\\\src\\\\objects\\\\test");
    	Users userCheck=  userList.isValid(loginUsername.getText(), loginPassword.getText());

    	if (userCheck!=null) { 
    		try {
    			userCheck.printUserInfo();
    			
    	    	FXMLLoader loader = new FXMLLoader();
    			VBox root = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
    			Scene scene = new Scene(root,900,900);
    			
    			controllerTwo = loader.getController();
    			controllerTwo.setPrimaryStage(primaryStage); 
    			controllerTwo.setMyScene(scene);
    			//controllerTwo.setNextController(this);  
    			controllerTwo.setUser(userCheck);  
    			controllerTwo.setUserList(userList); 
    			controllerTwo.loginUserSetup(userCheck);
    			 
    			
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
    		controllerTwo.takeFocus();
    	}
    	else {
     	}

    }

  //-------------------------------------------------------------------------------------------------------------------------------------------------   	
	
    
    @FXML
    void signUpAction(ActionEvent event) {
    	try { 
	    	FXMLLoader loader = new FXMLLoader();
			VBox homepageVbox = loader.load(new FileInputStream("src/view/SignUpPage.fxml"));
			Scene scene = new Scene(homepageVbox);
			
			controllerOne = loader.getController();
			controllerOne.setPrimaryStage(primaryStage);
			controllerOne.setMyScene(scene); 
			controllerOne.setUserList(userList);
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	controllerOne.takeFocus();
    }
    
    
}

