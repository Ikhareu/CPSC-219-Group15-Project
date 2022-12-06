package application;
	
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import userView.LoginController2;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(new FileInputStream("src/userView/Login Page.fxml"));
			Scene scene = new Scene(root, 640, 480);
			LoginController2 controller = (LoginController2)loader.getController();
			controller.setPrimaryStage(primaryStage);
			controller.setMyScene(scene);
			
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Find your Tutor");
			primaryStage.show();
			
			File file = new File("usersList.txt");
			if (file.length() == 0) {
				BufferedWriter writer = new BufferedWriter(new FileWriter("usersList.txt"));
				writer.write("Ohiomah 5875003780 Ohiomah2017\n");
				writer.close();
			}
			
			

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
