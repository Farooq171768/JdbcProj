package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBDemo2 {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		Properties properties= new Properties();
		
		properties.put("user", "postgres");
		properties.put("password","farooq14");
		
		try {
			
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url,properties);
			System.out.println("Connection established");
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
