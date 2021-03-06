package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;

public class UserDB {
	
//	public String getDepartment(int id) {
//		DbConnection con = new DbConnection();
//		Connection connection = con.getDbConnection();
//		try {
//			String sql =  "SELECT * FROM student "
//				     + "WHERE uid = ?;";
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setInt(1, id);
//			
//			ResultSet result = statement.executeQuery();
//			
//			if (result.next()) 
//			return result.getString("department");
//			return null;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	static public int onLogin(String email, String pwd) {
		DatabaseConnection con = new DatabaseConnection();
		Connection connection = con.getConnection();
		try {
			String sql = "SELECT * FROM users "
				     + "WHERE user_email_address = '"+email+"' AND user_password = '"+pwd+"';";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			int r = 0;
			if(result.next()) {
				System.out.println("gotten");
				r = result.getInt("user_id");
			}else {
				System.out.println("not gotten");
			}
			
			//connection.close();
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	static public int userId(String email) {
		DatabaseConnection con = new DatabaseConnection();
		Connection connection = con.getConnection();
		try {
			String sql = "SELECT * FROM users "
				     + "WHERE user_email_address = '"+email+"';";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			int r = 0;
			if(result.next()) {
			
				r = result.getInt("user_id");
			}else {
				
			}
			
			connection.close();
			return r;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return 0;
		}
	}
	static public String userName(String email) {
		DatabaseConnection con = new DatabaseConnection();
		Connection connection = con.getConnection();
		try {
			String sql = "SELECT * FROM users "
				     + "WHERE user_email_address = '"+email+"';";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			String r = "";
			if(result.next()) {
			
				r = result.getString("user_name");
			}else {
				
			}
			
			connection.close();
			return r;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return "";
		}
	}
	static public boolean exists(String email) {
		DatabaseConnection con = new DatabaseConnection();
		Connection connection = con.getConnection();
		try {
			String sql =  "SELECT user_email_address FROM users "
				     + "WHERE user_email_address = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
			//	connection.close();
				return true;
			}
			
			//connection.close();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	static public boolean createNjangi(String code, String name, String admin, String rules, int id) {
		DatabaseConnection con = new DatabaseConnection();
		Connection connection = con.getConnection();
		try {
			String sql = "INSERT INTO njangi"
					+ "(njangi_code, njangi_name, njangi_admin, njangi_rules, njangi_balance)"
					+ "VALUES"
					+ "(?, ?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, code);
			statement.setString(2, name);
			statement.setString(3, admin);
			statement.setString(4, rules);
			statement.setInt(5, 0);
			statement.execute();
			
			String sql1 = "INSERT INTO njangi_users"
					+ "(user_id, njangi_code, is_admin)"
					+ "VALUES"
					+ "(?, ?, ?);";
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			statement1.setInt(1, id);
			statement1.setString(2, code);
			statement1.setBoolean(3, true);
			statement1.execute();
			
			connection.close();
			return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
	}
	public  boolean joiNjangi(int id, String code) {
		DatabaseConnection con = new DatabaseConnection();
		Connection connection = con.getConnection();
		try {
			String sql = "INSERT INTO request"
					+ "(user_id, njangi_code)"
					+ "VALUES"
					+ "(?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, code);
			statement.execute();
			
			connection.close();
			return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
	}
	
//	public boolean isAdmitted(int uid) {
//		DBConnection con = new DBConnection();
//		Connection connection = con.getDbConnection();
//		try {
//			String sql =  "SELECT * FROM student "
//				     + "WHERE uid = ?;";
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setInt(1, uid);
//			
//			ResultSet result = statement.executeQuery();
//			
//			boolean admit = false;
//			if(result.next()) {
//				admit = result.getInt("status") == 1 ? true : false;
//			}
//			
//			connection.close();
//			return admit;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//	}
	
	static public boolean onAdd(String email, String pwd, String name, int balance) {
		DatabaseConnection con = new DatabaseConnection();
		Connection connection = con.getConnection();
		try {
			String sql = "INSERT INTO users"
					+ "(user_email_address, user_password, user_name, user_balance)"
					+ "VALUES"
					+ "(?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, pwd);
			statement.setString(3, name);
			statement.setInt(4, balance);
			
			statement.execute();
			
			//connection.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
//	public boolean updatePassword(String email, String pwd) {
//		DBConnection con = new DBConnection();
//		Connection connection = con.getDbConnection();
//		try {
//			String sql = "UPDATE student "
//					+ "SET password = ? "
//					+ "WHERE email = ?;";
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setString(1, pwd);
//			statement.setString(2, email);
//			
//			statement.execute();
//			
//			connection.close();
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//	}
	
//	public boolean updateStatus(int student_id, int status) {
//		DBConnection con = new DBConnection();
//		Connection connection = con.getDbConnection();
//		try {
//			String sql = "UPDATE student "
//					+ "SET status = ? "
//					+ "WHERE uid = ?;";
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setInt(1, status);
//			statement.setInt(2, student_id);
//			
//			statement.execute();
//			
//			connection.close();
//			
//			if(status == 1) {
//				courseDB c = new courseDB();
//				studentDB cl = new studentDB();
//				ObservableList<CourseListTable> cls = c.getCoursesFromDepartment(cl.getDepartment(student_id));
//				
//				
//				enrollDB e = new enrollDB();
//				for(int i = 0; i < cls.toArray().length; i++) {
//					e.onEnroll(((CourseListTable) cls.toArray()[i]).code, student_id);
//				}	
//			} else {
//				courseDB c = new courseDB();
//				studentDB cl = new studentDB();
//				ObservableList<CourseListTable> cls = c.getCoursesFromDepartment(cl.getDepartment(student_id));
//				
//				
//				enrollDB e = new enrollDB();
//				for(int i = 0; i < cls.toArray().length; i++) {
//					e.onDelete(((CourseListTable) cls.toArray()[i]).code, student_id);
//				}
//			}
//			
//			
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//	}
}
