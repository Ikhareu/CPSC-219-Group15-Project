package view;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

import java.io.FileInputStream;
import java.util.ArrayList;
import objects.Users;
import objects.Users_List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class FindStudensController {
	
	
	
	
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

	

    
	
	@FXML
    private ChoiceBox<String> courseTeachChoiceBox;
	
	
	
	public void setChoicebox(ArrayList <String> courses) {
		System.out.println(courses);
		ObservableList<String> setupList = FXCollections.observableArrayList(courses);
		courseTeachChoiceBox.setItems(setupList);
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------   	
	//Find Students
	
	
	
	
    @FXML
    private VBox findStudentPageVbox;
	

	
	@FXML
    void actionFindStudents(ActionEvent event) {
		
		
		String courseToFind="";
		try {
			courseToFind=courseTeachChoiceBox.getValue();
			System.out.println(courseToFind);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ArrayList <Users> Students = new ArrayList<Users>();
		
		Students = userList.getCourseStudents(courseToFind);
		VBox teachersContainer= new VBox(30);
		teachersContainer.setAlignment(Pos.CENTER);
		findStudentPageVbox.setAlignment(Pos.CENTER);
		Label lbl=new Label("Students who need help with: "+courseToFind);
		findStudentPageVbox.getChildren().add(lbl);
		
		for (Users indexUser: Students) {
			
			HBox container=new HBox(100);
			container.setAlignment(Pos.CENTER);
			Label fullName= new Label("Name: "+indexUser.getName());
			Label email= new Label("Email:"+indexUser.getEmail());
			Label phone= new Label("Phone number: "+indexUser.getPhone());
			
			container.getChildren().addAll(fullName,email,phone);

			Label lineShort=new Label("-------------------------------");
			teachersContainer.getChildren().addAll(container,lineShort);
			
			
			
		
			
			
			
		}
		Label line=new Label("-------------------------------------------------------------------");
		
		findStudentPageVbox.getChildren().addAll(teachersContainer,line);
		
		
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
			controllerTwo.setUser(user);
			controllerTwo.setUserList(userList);

			controllerTwo.loginUserSetup(user);
			controllerTwo.takeFocus();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

    }
	

}
