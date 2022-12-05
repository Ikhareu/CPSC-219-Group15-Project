package view;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import objects.Users;
import objects.Users_List;

public class EditDetailsController {
	
	private Stage primaryStage;
	private Scene myScene;
	private UserHomepageController controllerOne;
	private Users user;
	ArrayList<Users> userArray = Users_List.getArray();

    @FXML
    private TextField passwordText;

    @FXML
    private TextField usernameText;

    @FXML
    private TextField phoneText;

    @FXML
    private Button saveButton;

    @FXML
    private Label nameLabel;
    
    
    
    
    
    @FXML
    void goBack(ActionEvent event) {
    	if (controllerOne != null) {
    		controllerOne.takeFocus();
    	}
    }

    @FXML
    void saveChanges(ActionEvent event) {
    	String username = usernameText.getText();
        String password = passwordText.getText();
        String number = phoneText.getText();
        if (usernameValid(username) && numberValid(number) && !password.isEmpty()) {
    		Users_List.deleteUser(getUser());
    		Users newUser = new Users(username, number, password);
    		Users_List.addUser(newUser);
   			if (controllerOne != null) {
   				controllerOne.takeFocus();
    		}
    		
    	}
        else if (!usernameValid(username)) {
        	nameLabel.setTextFill(Color.RED);
        	nameLabel.setText("Invalid Username");
        	usernameText.clear();
        }
        else if (!numberValid(number)) {
        	nameLabel.setTextFill(Color.RED);
        	nameLabel.setText("Invalid Phone Number");
        	phoneText.clear();
        }
        else if (password.isEmpty()) {
        	nameLabel.setTextFill(Color.RED);
        	nameLabel.setText("Invalid Password");
        }
    	

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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public boolean usernameValid(String username) {
		if (username.isEmpty()) {
			return false;
		}
		for (Users user : userArray) {
			if(username == user.getName()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean numberValid(String number) {
		if (number.isEmpty()) {
			return false;
		}
		for (char c : number.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

}
