package application;
	

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.LoginController2;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/FirstPage.fxml"));
			Scene scene = new Scene(root, 640, 480);
			FirstPageController controller = (FirstPageController)loader.getController();
			controller.setPrimaryStage(primaryStage);
			controller.setMyScene(scene);
			
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Find your Tutor");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
