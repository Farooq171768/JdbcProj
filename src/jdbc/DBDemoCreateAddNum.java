package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoCreateAddNum {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
		
		//result set is also a resource whereas result_set_metadata is not a resource
		try {
			Class.forName("org.postgresql.Driver");
			try(Connection conn=DriverManager.getConnection(url,username,password);
					Statement stm= conn.createStatement()){
						
						String dropCmd= "drop procedure if exists apAddNum";
						String createCmd ="create procedure spAddNum(in a int, in b int, out c int) language plpgsql as $$ "+
						" begin "+
						" c := a+b;" +
						"end; $$";
						
						stm.execute(dropCmd);
						stm.execute(createCmd);
						
						System.out.println("Procedure is created successfully..");
											}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		catch(ClassNotFoundException e) {
			System.out.println(e);
		}

	}

}
