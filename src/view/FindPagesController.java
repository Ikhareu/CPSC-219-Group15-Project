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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class FindPagesController {
	
	
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
	
	
	
	

	
    @FXML
    private VBox findStudentPageVbox;
	
	
	@FXML
    private ChoiceBox<String> courseTeachChoiceBox;
	
	
	@FXML
    void actionFindStudents(ActionEvent event) {
		
		
		String courseToFind="";
		try {
			courseToFind=courseLearnChoiceBox.getValue();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ArrayList <Users> Students = new ArrayList<Users>();
		
		Students = userList.getCourseStudents(courseToFind);
		
		for (Users indexUser: Students) {
			
			HBox container=new HBox();
			Label fullName= new Label("Name: "+indexUser.getName());
			Label email= new Label("Email:"+indexUser.getEmail());
			Label phone= new Label("Phone number: "+indexUser.getPhone());
			
			container.getChildren().addAll(fullName,email,phone);
			
			findTutorPageVbox.getChildren().add(container);
			
			
		}
		
		
		
		
	}
	
	
	
	
	
    @FXML
    private VBox findTutorPageVbox;
	
	
	@FXML
    private ChoiceBox<String> courseLearnChoiceBox;
	 
	
	
	@FXML
    void actionFindTeachers(ActionEvent event) {
		String courseToFind="";
		try {
			courseToFind=courseTeachChoiceBox.getValue();
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

}
