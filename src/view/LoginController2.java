package view;

import java.io.FileInputStream;

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

	
	
    @FXML
    void loginAction(ActionEvent event) {
    	Users userCheck=  userList.isValid(loginUsername.getText(), loginPassword.getText());
    	System.out.println(userCheck);
    	System.out.println(loginUsername.getText());

    	System.out.println(loginPassword.getText());
    	
    	if (userCheck==null) { 
    		try {
    	    	FXMLLoader loader = new FXMLLoader();
    			VBox root = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
    			Scene scene = new Scene(root,900,900);
    			
    			controllerTwo = loader.getController();
    			controllerTwo.setPrimaryStage(primaryStage);
    			controllerTwo.setMyScene(scene);
    			//controllerTwo.setNextController(this); 
    			controllerTwo.setUser(userList.getUser(1));  
    			controllerTwo.setUserList(userList); 
    			controllerTwo.loginUserSetup(userList.getUser(1));
    			
    			
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
    		controllerTwo.takeFocus();
    	}
    	else {
    		System.out.println("boss");
    	}

    }

    @FXML
    void signUpAction(ActionEvent event) {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
			VBox homepageVbox = loader.load(new FileInputStream("src/view/SignUpPage.fxml"));
			Scene scene = new Scene(homepageVbox);
			
			controllerOne = loader.getController();
			controllerOne.setPrimaryStage(primaryStage);
			controllerOne.setMyScene(scene);
			controllerOne.setNextController(this);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	controllerOne.takeFocus();
    }
    
    
}

