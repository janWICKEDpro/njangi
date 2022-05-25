package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField user_email_address;
	@FXML
	private TextField user_password;
	
	@FXML
	private void onLogin(ActionEvent event) {
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
		// handle transition
	}
	
	public void show() {
		
	}
}
