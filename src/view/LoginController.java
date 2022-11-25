package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

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
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;

import java.io.IOException;

import javafx.scene.Node;



public class LoginController {
	
	public Stage applicationStage;
	
	

	
	
	   @FXML
	    void signUpAction(ActionEvent event) {
		   try 
			{
	    		
	    		 
	    		
	    		
	    		

		    	FXMLLoader loader = new FXMLLoader();
				VBox homepageVbox = loader.load(new FileInputStream("src/view/SignUpPage.fxml"));
				Scene scene = new Scene(homepageVbox,600,600);
				
				signupcontroller controller= (signupcontroller)loader.getController();
				controller.signUpStage = applicationStage;
				
		    	applicationStage.setScene(scene);
		    	applicationStage.show();
		    	
				
			
				
			} catch(Exception e)
			{ 
				e.printStackTrace();
			}
		}

	    @FXML
	    void loginAction(ActionEvent event) {
	    	
//	    	root = FXMLLoader.load(getClass().getResource("userhomepage.fxml"));
//	    	stage1 =  (Stage)((Node)event.getSource()).getScene().getWindow();
	    	try 
			{
	    		
	    		 
	    		
	    		
	    		

		    	FXMLLoader loader = new FXMLLoader();
				VBox homepageVbox = loader.load(new FileInputStream("src/view/userhomepage.fxml"));
				Scene scene = new Scene(homepageVbox,600,600);
				
				userhomepagecontroller controller= (userhomepagecontroller)loader.getController();
				controller.homePageStage = applicationStage;
				
		    	applicationStage.setScene(scene);
		    	applicationStage.show();
		    	
				
			
				
			} catch(Exception e)
			{ 
				e.printStackTrace();
			}
		}

	

	    @FXML
	    private TextField loginusernmae;

	    @FXML
	    private PasswordField loginpassword;
		

	
	
	
	
}

