package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateController implements Initializable {
	private String admin_name;
	@FXML
	private Button create;
	@FXML
	private Button cancel;
	@FXML
	private TextField Levi;
	@FXML
	private TextField name;
	@FXML
	private TextField rules;
	@FXML
	private TextField duration;
	
	@FXML
	private void createNjangi(ActionEvent e) {
		
		boolean result = UserDB.createNjangi(generateCode(), name.getText(), admin_name, rules.getText(), 1);
		if(result) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Success");
			alert.setHeaderText("Successfully created the Njangi");
			alert.setContentText("click ok to continue and go into myNjangi(s) to find it");
		}
	}
	@FXML
	private void cancelAndGoBack(ActionEvent e) {
		cancel.getScene().getWindow().hide();
		//boolean result = UserDB.createNjangi(generateCode(), name.getText(), admin_name, rules.getText(), 0);
	}
	
	private String generateCode() {
		String code = "adf2s";
		
		return code;
	}
	
	
	public void init(String user_name) {
		admin_name = user_name;
		System.out.println(admin_name);
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
