package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NewHomeController implements Initializable{
	private int id;
	private String userName;
	private Stage primaryStage;
	@FXML
	private Label name;

	public void init(String user_name, int user_id) {
		userName = user_name;
		
		name.setText(userName);
		id = user_id;
	}
	
	@FXML
	public void showLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml")); // for login
		primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root, 600, 400); // for login
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	// Event Listener on Button.onAction
	@FXML
	public void showCreate(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Create.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root); // for login
		CreateController controller = loader.getController();
		controller.init(userName);
		
		primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();	
		}
	// Event Listener on Button.onAction
	@FXML
	public void ShowMynjangi(ActionEvent event) {
		// TODO Autogenerated
		System.out.println(userName);
	}
	// Event Listener on Button.onAction
	@FXML
	public void showJoin(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Join.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root); // for login
		JoinController controller = loader.getController();
		controller.init(id);
		
		primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();	
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
}
