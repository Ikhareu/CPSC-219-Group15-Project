package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {
	
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
    void cancelAction(ActionEvent event) {

    }

    @FXML
    void signUpAction(ActionEvent event) {

    }
	
	private Stage primaryStage;
	private Scene myScene;
	private LoginController2 controllerTwo;
    
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
