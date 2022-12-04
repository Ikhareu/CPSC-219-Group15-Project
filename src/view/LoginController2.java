package view;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import objects.Users;
import objects.Users_List;

public class LoginController2 {
	
	@FXML
	public Label everythingLabel;

    @FXML
    private TextField loginUsername;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Hyperlink createAccountHyperlink;
    
    

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
    	
    		try {
    			if (Users_List.isValid(username, password, Users_List.getArray())) {
	    	    	FXMLLoader loader = new FXMLLoader();
	    			Pane homepagePane = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
	    			Scene scene = new Scene(homepagePane);
	    			
	    			controllerTwo = loader.getController();
	    			controllerTwo.setPrimaryStage(primaryStage);
	    			controllerTwo.setMyScene(scene);
	    			controllerTwo.setNextController(this);
	        		controllerTwo.takeFocus();
	        		loginUsername.clear();
	        		loginPassword.clear();
	        		
    			}
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
    	

    }

    @FXML
    void signUpAction(ActionEvent event) {
    	if (Users_List.isValid("Charlie", "Charlie2017", Users_List.getArray())) {
    		System.out.println("abcdef");
    	}
    	try {
	    	FXMLLoader loader = new FXMLLoader();
			VBox homepageVbox = loader.load(new FileInputStream("src/view/SignUpPage.fxml"));
			Scene scene = new Scene(homepageVbox);
			
			controllerOne = loader.getController();
			controllerOne.setPrimaryStage(primaryStage);
			controllerOne.setMyScene(scene);
			controllerOne.setNextController(this);
			
			controllerOne.takeFocus();
			loginUsername.clear();
    		loginPassword.clear();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    
}

