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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.Pane;



public class userhomepagecontroller {


	public Stage homePageStage;
	
	
	
	
	
	
	
	
	
	
	
	

    @FXML
    private Label idUser;

    @FXML
    private Label userPhone;

    @FXML
    private Label UserPassword;

    @FXML
    private Label userEmail;
    
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
    void coursepageaction(ActionEvent event) { 
    	
    	

    	
    	Scene MainScene=homePageStage.getScene();

    	VBox CourseContainer=new VBox();
    	

    	Label teachLabel= new Label("Can Help") ;

    	Label learnLabel= new Label("Need Help") ;
    	
    	Label spacelabel= new Label();
    	
    	



		CourseContainer.getChildren().add(teachLabel);

    	ArrayList <String> courseArrayLearn = new ArrayList<String>();

    	ArrayList <String> courseArrayTeach = new ArrayList<String>();
    	
    	int i =0; 
    	
    	while (i<3) {
    		 
    		HBox courseLearn= new HBox();
    		Label courseLearnLabel= new Label("Enter the course:");
    		TextField courseLearnText = new TextField();
    		courseArrayLearn.add(courseLearnText.getText());
    		
    		courseLearn.getChildren().addAll(courseLearnLabel, courseLearnText);
    		
    		
    		
    		CourseContainer.getChildren().add(courseLearn);
    		i++;
    		
    		
    	}
    	
    	i=0;
    	


		CourseContainer.getChildren().add(learnLabel);
    	
    	while (i<3) {
    		
    		HBox courseLearn= new HBox();
    		Label courseLearnLabel= new Label("Enter the course:");
    		TextField courseLearnText = new TextField();

    		courseArrayLearn.add(courseLearnText.getText());
    		
    		courseLearn.getChildren().addAll(courseLearnLabel, courseLearnText);
    		
    		
    		
    		CourseContainer.getChildren().add(courseLearn);
    		i++;
    		
    		
    	}
    	
    	Scene courseScene= new Scene(CourseContainer, 600,700);
    	homePageStage.setScene(courseScene);
    	
    	
    	Users user1= new Users();
    	Users_List allusers= new Users_List();
    	user1.addCourses(courseArrayLearn, courseArrayTeach);
    	allusers.addUser(user1);
    	
    	

    }

    @FXML
    void findTutor(ActionEvent event) {

    }

}
	

//	void register(actioneven) {
//		
//		login=label1.getvalue
//		password = label
//		
//		userRegistered(label, email,phone,id)
//		
//		userList.adduse(userRegistered)
//	}
	

