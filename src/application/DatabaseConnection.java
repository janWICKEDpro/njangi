package application;

import java.sql.*;
public class DatabaseConnection {
	Connection link;
	
	Connection getConnection() {
		String databaseName = "njangi";
		String databaseUser = "root";
		//put ya password
		String databasePassword = "";
		String url = "jdbc:mysql://localhost:33060/" + databaseName;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			link = DriverManager.getConnection(url, databaseUser, databasePassword);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return link;
	}
}
