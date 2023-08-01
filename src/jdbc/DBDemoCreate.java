package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBDemoCreate {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url,username,password);
			
			Statement stm= connection.createStatement();
			
			String dropCmd="drop table if exists emp";
			String createCmd="create table emp(empid int primary key,ename varchar(40),salary numeric(12,2))";
			
			stm.execute(dropCmd);
			stm.execute(createCmd);
			
			System.out.println("table created");
			
			stm.close();
			connection.close();
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
