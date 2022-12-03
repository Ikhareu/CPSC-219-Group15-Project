package view;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import objects.Users;
import objects.Users_List;

public class FindTutorsController {
	
	
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
    
	private Stage primaryStage;
	private Scene myScene;
	private SignUpController controllerOne;
	private UserHomepageController controllerTwo;
	


		
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}
	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);  
	}
	

	
	
//-------------------------------------------------------------------------------------------------------------------------------------------------    	
//Find Tutor
	
	
    @FXML
    private VBox findTutorPageVbox;
	
	
	@FXML
    private ChoiceBox<String> courseLearnChoiceBox; // learn because these are the courses student need to learn
	 
	
	
	@FXML
    void actionFindTeachers(ActionEvent event) {
		String courseToFind="";
		try {
			courseToFind=courseLearnChoiceBox.getValue();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ArrayList <Users> Teachers = new ArrayList<Users>();
		
		Teachers = userList.getCourseTeachers(courseToFind);
		
		for (Users indexUser: Teachers) {
			
			HBox container=new HBox();
			Label fullName= new Label("Name: "+indexUser.getName());
			Label email= new Label("Email:"+indexUser.getEmail());
			Label phone= new Label("Phone number: "+indexUser.getPhone());
			
			container.getChildren().addAll(fullName,email,phone);
			
			findTutorPageVbox.getChildren().add(container);
			
			
		}
		
		
		
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------   	
	
	@FXML
    void goHomePage(ActionEvent event) {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/view/UserHomepage.fxml"));
			Scene scene = new Scene(root, 900, 900);
 
			controllerTwo = loader.getController();
			controllerTwo.setPrimaryStage(primaryStage);
			controllerTwo.setMyScene(scene);
			controllerTwo.setUser(userList.getUser(1));
			controllerTwo.setUserList(userList);

			controllerTwo.takeFocus();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

    }
	

}
