package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class JoinController {
	private int user_id;
	@FXML
	private Button join;
	@FXML
	private TextField code;
	
	@FXML
	private void joinNjangi(ActionEvent e) {
		System.out.println(user_id);
	}
	
	public void init(int id) {
		user_id = id;
	}
	
}
