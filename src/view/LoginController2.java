package view;

import java.io.FileInputStream;
import java.util.ArrayList;

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
	Users_List u1 = new Users_List();
	
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
	private UserHomepageController controllerTwo = new UserHomepageController();
    
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
    	ArrayList <Users> array = Users_List.getArray();
    	try {
    		if (isValid(username, password, array) != null) {
    			Users user = isValid(username, password, array);
	    	    FXMLLoader loader = new FXMLLoader();
	    		Pane homepagePane = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
	    		Scene scene = new Scene(homepagePane);
	    		
	    		controllerTwo.setUser(user);
	    		controllerTwo = loader.getController();
	    		controllerTwo.setPrimaryStage(primaryStage);
	    		controllerTwo.setMyScene(scene);
	    		controllerTwo.setNextController(this);
	        	controllerTwo.takeFocus();
	        		
	        		
    		}
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    	loginUsername.clear();
    	loginPassword.clear();
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
			
			controllerOne.takeFocus();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	loginUsername.clear();
		loginPassword.clear();
    }
    
    Users isValid(String username, String password, ArrayList <Users> list) {
		Users answer = null;
    	for (Users user : list) {
    		if ((user.getName().equals(username)) && (user.getPassword().equals(password))) {
    			answer = user;
    			return user;
    		}
    	}
    	return answer;
    	}    
}

