package view;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.FileInputStream;
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
	
	private LoginController2 controllerLogin;
	private FindPagesController controllerFind;
	private CoursesPageController controllerCourses;

    public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}
	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
//	public void setNextController(LoginController2 aController) {
//		controllerLogin = aController;
//	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

	//-------------------------------------------------------------------------------------------------------------------------------------------------   	
	


	
	
    
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
    
	//-------------------------------------------------------------------------------------------------------------------------------------------------   	

	
	public void setUpController(Users usr,Users_List uList, Stage aStage,Scene aScene) {
		
		userList= uList;
		user=usr;

		primaryStage.setScene(myScene);
		myScene = aScene;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------   	

	
	
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
    private Label idUser;

    @FXML
    private Label userPhone;

    @FXML
    private Label UserPassword;

    @FXML
    private Label userEmail;
    
    
   
    public void loginUserSetup(Users usr) {
    	idUser.setText(usr.getUserID()+"");
    	userPhone.setText(usr.getPhone());
    	userEmail.setText(usr.getEmail());
    	
    }
    
    @FXML
    void checkAction(ActionEvent event) {

    }

    @FXML
    void editProfileAction(ActionEvent event) {

    }
    
    @FXML
    void editEmail(ActionEvent event) {

    }

    @FXML
    void editPhone(ActionEvent event) {

    }

    @FXML
    void editPassword(ActionEvent event) {
    }

    @FXML
    void logoutAction(ActionEvent event) {

    }
    

	
	
	
	
	@FXML
	void coursepageaction(ActionEvent event) {
		
		try {
	    	FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/view/CoursesPage.fxml"));
			Scene scene = new Scene(root,900,900);
			
			controllerCourses = loader.getController();
			controllerCourses.setPrimaryStage(primaryStage);
			controllerCourses.setMyScene(scene);
			controllerCourses.setUser(user); 
			controllerCourses.setUserList(userList); 
			
			
			
			
			
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		controllerCourses.takeFocus();

		

	}
	
	

    @FXML
    void findTutor(ActionEvent event) {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/view/FindTutorPage.fxml"));
			Scene scene = new Scene(root,900,900);
			
			controllerFind = loader.getController();
			controllerFind.setPrimaryStage(primaryStage);
			controllerFind.setMyScene(scene);
			controllerFind.setUser(user); 
			controllerFind.setUserList(userList); 
			
			
			
			
			
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		controllerFind.takeFocus();

    }

    @FXML
    void findStudentAction(ActionEvent event) {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/view/FindStudentPage.fxml"));
			Scene scene = new Scene(root,900,900);
			
			controllerFind = loader.getController();
			controllerFind.setPrimaryStage(primaryStage);
			controllerFind.setMyScene(scene);
			controllerFind.setUser(user); 
			controllerFind.setUserList(userList); 
			}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		


    }
	
	
	

}
