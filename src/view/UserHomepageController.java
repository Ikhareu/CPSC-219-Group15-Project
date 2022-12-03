package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class UserHomepageController {
	
	private Stage primaryStage;
	private Scene myScene;
	private LoginController2 controllerThree;

    @FXML
    private ChoiceBox<String> courseChoiceBox;

    @FXML
    private MenuItem editProfileButton;

    @FXML
    private Button checkButton;

    @FXML
    private MenuItem logoutButton;

    @FXML
    private MenuButton nameLabel;

    @FXML
    void checkAction(ActionEvent event) {

    }

    @FXML
    void editProfileAction(ActionEvent event) {

    }

    @FXML
    void logoutAction(ActionEvent event) {
    	if (controllerThree != null) {
    		controllerThree.takeFocus();
    	}
    }
    
    public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}
	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void setNextController(LoginController2 aController) {
		controllerThree = aController;
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

}
