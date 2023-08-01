package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBDemoPrepared {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
		try {
			Class.forName("org.postgresql.Driver");
			String insertCmd= "insert into emp values(?,?,?)";// we can use this query directly inside argument of Prepared statement 
			try(Connection conn = DriverManager.getConnection(url,username,password);
					PreparedStatement  stm=conn.prepareStatement(insertCmd)) {
				
				stm.setInt(1, 160);
				stm.setString(2, "wer");
				stm.setDouble(3, 41000);
				
				int cnt = stm.executeUpdate(); //There is no argument as of createStatement
				System.out.println(cnt +"row(s) inserted");
				
			}
		}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}

	}



