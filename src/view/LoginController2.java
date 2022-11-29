package view;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private PasswordField loginPassword;

    @FXML
    private Hyperlink createAccountHyperlink;
    
    public Users_List userList = new Users_List();
    

	private Stage primaryStage;
	private Scene myScene;
	private SignUpController controllerOne;
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

    @FXML
    void loginAction(ActionEvent event) {
    	String username = loginUsername.getText();
    	String password = loginPassword.getText();
    	if (userList.isValid(username, password)) {
    		try {
    	    	FXMLLoader loader = new FXMLLoader();
    			Pane homepagePane = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
    			Scene scene = new Scene(homepagePane);
    			
    			controllerTwo = loader.getController();
    			controllerTwo.setPrimaryStage(primaryStage);
    			controllerTwo.setMyScene(scene);
    			controllerTwo.setNextController(this);
    			
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
    		controllerTwo.takeFocus();
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

