package view;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.FileInputStream;
import java.io.IOException;
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
import javafx.scene.layout.Pane;
import javafx.scene.control.*;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserHomepageController {
	
	private Stage primaryStage;
	private Scene myScene;
	
	private LoginController2 controllerLogin;
	private FindStudensController controllerFindStudents;
	private FindTutorsController controllerFindTutors;
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
    
    @FXML
    private HBox saveHbox;

    @FXML
    private VBox editVbox;

    @FXML
    private VBox editVbox2;

    @FXML
    private VBox editVbox1;
    
  //-------------------------------------------------------------------------------------------------------------------------------------------------   	
  
   
    public void loginUserSetup(Users usr) {
    	
    	
    	userNameLabel.setText(usr.getName());
    	userPhone.setText(usr.getPhone());
    	userEmail.setText(usr.getEmail());
    	
    	passwordTXT.setText(usr.getPassword()); 
		phoneTXT.setText(usr.getPhone());
		emailTXT.setText(usr.getEmail());
		
    	passwordTXT.setVisible(false);
		emailTXT.setVisible(false);
		phoneTXT.setVisible(false);
		saveChangesbutton.setVisible(false);
	}
    	
    //------------------------------------------------------------------------------------------------------------------------------------------------- 
    @FXML
    private Label userNameLabel;

    @FXML
    private TextField passwordTXT;
    @FXML
    private TextField emailTXT;
    @FXML
    private TextField phoneTXT;
    
    
    @FXML
    private Button editbutton;
    
    @FXML
    private Button saveChangesbutton;
    

    //-------------------------------------------------------------------------------------------------------------------------------------------------   	
    
    @FXML
    void saveChanges() throws IOException {
    	editbutton.setVisible(true);
    	saveChangesbutton.setVisible(false);
    	
    	try {
    		
    		
    		if (!passwordTXT.getText().equals("")) {

    			String pasSTR=passwordTXT.getText();
    			user.setPassword(pasSTR);
    			}
    	}
    	catch(Exception e) {


    		System.out.println("password empty");
    		e.printStackTrace();
    	}
		
		try {
			if (!emailTXT.getText().equals("")) {
			String emailSTR=emailTXT.getText();
			user.setEmail(emailSTR);
			}
    	}
    	catch(Exception e) {
    		e.printStackTrace();

    		System.out.println("email empty");
    	}
		
		try {
			if (!phoneTXT.getText().equals("")) {
			String phoneSTR=phoneTXT.getText();
			user.setPhone(phoneSTR);
			}
		}
    	catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("phone empty");
    	}

    	userNameLabel.setText(user.getName()+"");
    	
    	userPhone.setText(user.getPhone());
    	userEmail.setText(user.getEmail());
    	//UserPassword.setText(user.getPassword());
    	
		passwordTXT.setVisible(false);
		emailTXT.setVisible(false);
		phoneTXT.setVisible(false);

    	userList.saveUserListAsTxt("C:\\\\Users\\\\dadada\\\\git\\\\CPSC-219-Group15-Project\\\\src\\\\objects\\\\AllUsersTXTFILE");
    }
    
    
    @FXML
	void editInfoAction(ActionEvent event) {
    	saveChangesbutton.setVisible(true);
    	editbutton.setVisible(false);

		passwordTXT.setVisible(true);
		emailTXT.setVisible(true); 
		phoneTXT.setVisible(true);

		
    }

    
    

    //-------------------------------------------------------------------------------------------------------------------------------------------------   	
    
    @FXML
    void logoutAction(ActionEvent event) {
    	
    	
		try {
	    	FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(new FileInputStream("src/view/Login Page.fxml"));
			Scene scene = new Scene(root,900,900);
			
			controllerLogin = loader.getController();
			controllerLogin.setPrimaryStage(primaryStage);
			controllerLogin.setMyScene(scene);
			controllerLogin.setUserList(userList); 
			
			
			
			
			
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		controllerLogin.takeFocus();

    	
    	
    	
    	
    }

  //-------------------------------------------------------------------------------------------------------------------------------------------------   	

	
	
	
	@FXML
	void coursepageaction(ActionEvent event) {
		
		try {

	    	userList.saveUserListAsTxt("C:\\Users\\dadada\\git\\CPSC-219-Group15-Project\\src\\objects\\AllUsersTXTFILE");
	    	FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/view/CoursesPage.fxml"));
			Scene scene = new Scene(root,900,900);
			
			controllerCourses = loader.getController();
			controllerCourses.setPrimaryStage(primaryStage);
			controllerCourses.setMyScene(scene);
			controllerCourses.setUser(user); 
			controllerCourses.setUserList(userList); 
			controllerCourses.addUserCoursesLearn();  
			controllerCourses.addUserCoursesTeach();
			
			
			
			
			
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		controllerCourses.takeFocus();

		

	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------   	

    @FXML
    void findTutor(ActionEvent event) {
    	try {

        	userList.saveUserListAsTxt("C:\\Users\\dadada\\git\\CPSC-219-Group15-Project\\src\\objects\\AllUsersTXTFILE");
    		
	    	FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/view/FindTutorPage.fxml"));
			Scene scene = new Scene(root,900,900);
			

			controllerFindTutors = loader.getController();
			controllerFindTutors.setPrimaryStage(primaryStage);
			controllerFindTutors.setMyScene(scene);
			controllerFindTutors.setUser(user); 
			controllerFindTutors.setUserList(userList); 
			controllerFindTutors.takeFocus();
			controllerFindTutors.setChoicebox(user.getcoursesToLearn());
			
			
			
			
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}

    }
  //-------------------------------------------------------------------------------------------------------------------------------------------------   	

    @FXML
    void findStudentAction(ActionEvent event) {
    	try {

        	userList.saveUserListAsTxt("C:\\Users\\dadada\\git\\CPSC-219-Group15-Project\\src\\objects\\AllUsersTXTFILE");
	    	FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/view/FindStudentPage.fxml"));
			Scene scene = new Scene(root,900,900);
			
			
			controllerFindStudents = loader.getController();
			controllerFindStudents.setPrimaryStage(primaryStage);
			controllerFindStudents.setMyScene(scene);
			controllerFindStudents.setUser(user); 
			controllerFindStudents.setUserList(userList);  
			controllerFindStudents.takeFocus();
			controllerFindStudents.setChoicebox(user.getcoursesToTeach());
			
			} 
    	catch(Exception e) {
    		e.printStackTrace(); 
    	}
		


    }
	
	
	

}
