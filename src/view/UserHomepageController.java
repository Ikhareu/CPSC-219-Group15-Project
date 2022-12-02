package view;



import javafx.fxml.FXML;

import java.util.ArrayList;
import objects.Users;
import objects.Users_List;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

import javafx.scene.Scene;
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

    }
    
    
    private Users user;
    
    

    public Users_List userList = new Users_List();
	
	
	
	public Users_List getUserList() {
		return(userList);
	}
    
	public void setUserList(Users_List uList) {
		userList= uList;
		
	}
    
    
    public void setUser(Users usr) {
    	user=usr;
    	
    }
    
    public Users getUser() {
    	
    	return(user);
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
	
	
	
	
	@FXML
	void coursepageaction(ActionEvent event) {

		Scene MainScene = primaryStage.getScene();

		VBox CourseContainer = new VBox();

		Label teachLabel = new Label("Can Help");

		Label learnLabel = new Label("Need Help");

		Label spacelabel = new Label();

		CourseContainer.getChildren().add(teachLabel);

		ArrayList<String> courseArrayLearn = user.getcoursesToLearn();

		ArrayList<String> courseArrayTeach = user.getcoursesToTeach();

		int i = 0;

		while (i < courseArrayLearn.size()) {

			HBox courseLearn = new HBox();
			Label courseLearnLabel = new Label("Enter the course:");
			TextField courseLearnText = new TextField();
			courseLearnText.setText(courseArrayLearn.get(i));
			
			courseArrayLearn.add(courseLearnText.getText());

			courseLearn.getChildren().addAll(courseLearnLabel, courseLearnText);

			CourseContainer.getChildren().add(courseLearn);
			i++;  

		}

		i = 0;
		

		CourseContainer.getChildren().add(learnLabel);

		while (i < 3) {
 
			HBox courseLearn = new HBox();
			Label courseLearnLabel = new Label("Enter the course:");
			TextField courseLearnText = new TextField();

			courseArrayLearn.add(courseLearnText.getText());

			courseLearn.getChildren().addAll(courseLearnLabel, courseLearnText);

			CourseContainer.getChildren().add(courseLearn);
			i++;

		}

		Scene courseScene = new Scene(CourseContainer, 600, 700);
		primaryStage.setScene(courseScene);

		
		user.addCourses(courseArrayLearn, courseArrayTeach);

	}
	
	
	
	

}
