package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoInsert {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			Statement stm = connection.createStatement();
			

			int empno=Integer.parseInt(args[0]);
			
			String ename=args[1];
			double salary=Double.parseDouble(args[2]);
			
			String insertCmd="insert into emp values("+empno+",'"+ename+"',"+salary+")";
			
			int cnt =stm.executeUpdate(insertCmd);
			
			System.out.println(cnt+" row(s) inserted");
			
			stm.close();
			connection.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
