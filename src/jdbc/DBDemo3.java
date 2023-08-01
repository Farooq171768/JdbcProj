package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemo3 {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection conn=DriverManager.getConnection(url,username,password);Statement stm=conn.createStatement()){
			System.out.println("connection established");
			String dropCmd="drop table if exists student";
			String createCmd="create table student(rollno int primary key,name varchar(50),age int)";
			stm.execute(dropCmd);
			stm.execute(createCmd);
			System.out.println("Table created");
			String insertCmd="insert into student values(12,'jhy',20)";
			int cnt = stm.executeUpdate(insertCmd);
			System.out.println(cnt+" row(s) inserted..");
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}

}
