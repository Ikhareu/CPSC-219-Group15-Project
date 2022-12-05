package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.LoginController2;

public class FirstPageController {
	private Stage primaryStage;
	private Scene myScene;
	private LoginController2 controllerOne;
	
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
    void goToStudent(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		Pane homepagePane = loader.load(new FileInputStream("src/view/Login Page.fxml"));
    		Scene scene = new Scene(homepagePane);
    		
    		controllerOne = loader.getController();
    		controllerOne.setPrimaryStage(primaryStage);
    		controllerOne.setMyScene(scene);
    		controllerOne.setNextController(this);
    		controllerOne.takeFocus();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}

    }

    @FXML
    void goToTutor(ActionEvent event) {

    }

}
