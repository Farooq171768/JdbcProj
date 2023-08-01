package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class DBDemo {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
//		Way-1 Register driver with DRiverManager class
//		try {
//		Class.forName("org.postgresql.Driver");
//		//get connection object
//		Connection connection= DriverManager.getConnection(url,username,password);
//		System.out.println("Connection established");
//		
//		connection.close();
//		}
//		catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		catch(SQLException se) {
//			se.printStackTrace();
//		Way-2
		try {
			DriverManager.registerDriver(new Driver());
			Connection connection = DriverManager.getConnection(url,username,password);
			System.out.println("Connection established");
			
			connection.close();
			
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
	}

}
