package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditDetailsController {
	
	private Stage primaryStage;
	private Scene myScene;
	private UserHomepageController controllerOne;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField usernameText;

    @FXML
    private TextField emailText;

    @FXML
    private Button saveButton;

    @FXML
    private Label nameLabel;
    
    @FXML
    void goBack(ActionEvent event) {

    }

    @FXML
    void saveChanges(ActionEvent event) {

    }
    
    public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}
	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void setNextController(UserHomepageController aController) {
		controllerOne = aController;
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

}
