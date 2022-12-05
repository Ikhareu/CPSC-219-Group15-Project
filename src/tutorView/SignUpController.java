package tutorView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import objects.Users;
import objects.Users_List;

public class SignUpController {
	
	private Stage primaryStage;
	private Scene myScene;
	private LoginController2 controllerTwo;
	
    @FXML
    private TextField passwordTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField password2TextField;
    
    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Button signUpButton;

    @FXML
    void cancelAction(ActionEvent event) {
    	if (controllerTwo != null) {
    		controllerTwo.takeFocus();
    	}
    }
 
    @FXML
    void signUpAction(ActionEvent event) {
    	String name = nameTextField.getText();
    	String phoneNumber = phoneNumberTextField.getText();
    	String password = passwordTextField.getText();
    	Users newUser = new Users(name, phoneNumber, password);
    	Users_List.addUser(newUser);
    	if (controllerTwo != null) {
    		controllerTwo.takeFocus();
    	}
    	controllerTwo.everythingLabel.setTextFill(Color.LIME);
    	controllerTwo.everythingLabel.setText("Account created succesfully");
    }	
    
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}
	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void setNextController(LoginController2 aController) {
		controllerTwo = aController;
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
}
