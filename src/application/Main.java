package application;
	
import java.sql.Connection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml")); // for login
			Scene scene = new Scene(root, 600, 400); // for login
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ninjangi");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			// Instantiates Database
			DatabaseConnection dbConnection = new DatabaseConnection();
			
			Connection con =dbConnection.getConnection();
			dbConnection.instantiateDB();
			if(con != null) System.out.println("connected");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
