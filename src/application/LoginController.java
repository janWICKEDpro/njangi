package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {
	private Stage primaryStage;
	private Parent root;
	private Scene scene;
	@FXML
	private TextField user_email_address;
	@FXML
	private TextField user_password;
	
	@FXML
	private void onLogin(ActionEvent event) throws IOException {
		String email = user_email_address.getText();
		String password = user_password.getText();
		
		if(email.isEmpty()) {
			return;
		}
		
		if(password.isEmpty()) {
			return;
		}
		
		if(!UserDB.exists(email)) {
			
			return;
			// handle no user found
		}
		
		int user_code = UserDB.onLogin(email, password);
		if(user_code >= 1) {
			System.out.println("logged");
			show(event,email);
		}else {
			System.out.println("not logged");
		}
		
	}
	
	@FXML
	private void showSignUp(MouseEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SignUp.fxml")); // for login
		primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root, 600, 400); // for login
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public void show(ActionEvent event, String email) throws IOException {
		int id = UserDB.userId(email);
		String user_name = UserDB.userName(email);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("NewHome.fxml"));
	    root = loader.load();
		Scene scene = new Scene(root); // for login
		NewHomeController controller = loader.getController();
		controller.init(user_name,id);
		
		primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
