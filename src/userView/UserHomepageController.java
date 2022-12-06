package userView;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import objects.Users;

public class UserHomepageController {
	
	private Stage primaryStage;
	private Scene myScene;
	private LoginController2 controllerOne;
	private EditDetailsController controllerTwo;
	private Users user;

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

    public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@FXML
    void checkAction(ActionEvent event) {

    }

    @FXML
    void editProfileAction(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		VBox homepageVBox = loader.load(new FileInputStream("src/userView/EditDetails.fxml"));
    		Scene scene = new Scene(homepageVBox);
    		
    		controllerTwo = loader.getController();
    		controllerTwo.setPrimaryStage(primaryStage);
    		controllerTwo.setMyScene(scene);
    		controllerTwo.setNextController(this);
    		
    		controllerTwo.takeFocus();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void logoutAction(ActionEvent event) {
    	if (controllerOne != null) {
    		controllerOne.takeFocus();
    	}
    	controllerOne.everythingLabel.setTextFill(Color.LIME);
    	controllerOne.everythingLabel.setText("Logout successful");
    }
    
    public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}
	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void setNextController(LoginController2 aController) {
		controllerOne = aController;
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

}
