package application;

import java.sql.*;

public class DatabaseConnection {
	Connection link;
	String databaseName = "njangi";
	String databaseUser = "root";
	//put ya password
	String databasePassword = "";
	Connection getConnection() {
		
		String url = "jdbc:mysql://localhost:33060/" + databaseName;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			link = DriverManager.getConnection(url, databaseUser, databasePassword);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			instantiateDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return link;
	}
	
	public void instantiateDB() throws SQLException {	
		Statement statement;
		String sql;
		boolean found = false;
		statement = link.createStatement();
		ResultSet rs = link.getMetaData().getCatalogs();
		while(rs.next()) {
			if(databaseName.equals(rs.getString(1))) {
				found = true;
			}
		}
			
		if(found) {
			sql = "DROP DATABASE " + databaseName + ";";
			statement.execute(sql);
		}
			
		sql = "CREATE DATABASE " + databaseName + ";";
		statement.execute(sql);
		sql = "use " + databaseName + ";";
		statement.execute(sql);
		sql = "CREATE TABLE users("
				+ "	user_id int primary key auto_increment,"
				+ "    user_name varchar(20),"
				+ "    user_email_address varchar(20),"
				+ "    user_password varchar(20),"
				+ "    user_balance int"
				+ ");";
		statement.execute(sql);
		sql = "CREATE TABLE njangi("
				+ "	njangi_code varchar(5) primary key,"
				+ "    njangi_name varchar(10),"
				+ "    njangi_admin varchar(20),"
				+ "    njangi_rules varchar(100),"
				+ "    njangi_balance int\r\n"
				+ ");";
		statement.execute(sql);
		sql = "CREATE TABLE njangi_users("
				+ "	user_id int,"
				+ "    njangi_code varchar(5),"
				+ "    foreign key (user_id) references users(user_id),"
				+ "	foreign key (njangi_code) references njangi(njangi_code),"
				+ "	primary key(user_id, njangi_code)"
				+ ");";
		statement.execute(sql);
		sql = "CREATE TABLE request("
				+ "	user_id int,"
				+ "    njangi_code varchar(5),"
				+ "    state varchar(15) default \"pending\","
				+ "	foreign key (user_id) references users(user_id),"
				+ "	foreign key (njangi_code) references njangi(njangi_code),"
				+ "    primary key(user_id, njangi_code)"
				+ ");";
		statement.execute(sql);
		
//		// loads dummy Data
//		new DummyDB();
//		
//		connection.close();
	}
}
