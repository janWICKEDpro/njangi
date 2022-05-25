package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class SignUpController {
	private Stage primaryStage ;
	@FXML
	private Button signupButton;
	@FXML
	private TextField name;
	@FXML
	private TextField email;
	@FXML
	private TextField password;
	@FXML
	private Label loginButton;
	
	@FXML
	private void showSignUp(ActionEvent e) throws IOException {
		
		String user_name = name.getText();
		String user_email_address = email.getText();
		String user_password = password.getText();
		
		boolean res = UserDB.onAdd(user_email_address, user_password, user_name, 100000);
		int id = UserDB.userId(user_email_address);
		if(res) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("NewHome.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root); // for login
			NewHomeController controller = loader.getController();
			controller.init(user_name,id);
			
			primaryStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		}else {
			System.out.println("no success");
		}
	}
	
	@FXML
	private void showLogin(MouseEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml")); // for login
		primaryStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root, 600, 400); // for login
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
