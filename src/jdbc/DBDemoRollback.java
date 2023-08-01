package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBDemoRollback {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
		try {
			Class.forName("org.postgresql.Driver");
			String cmd="update emp set salary=77000 where empid=?";
			try(Connection conn=DriverManager.getConnection(url,username,password);
					PreparedStatement ps=conn.prepareStatement(cmd)){
				
				conn.setAutoCommit(false);
				ps.setInt(1, Integer.parseInt(args[0]));
				int count = ps.executeUpdate();
				
				if(count>0) {
					System.out.println("Update successful");
				}
				else {
					System.out.println("No such employee");
				}
				conn.rollback();
				System.out.println("Transaction rolled back");
				conn.setAutoCommit(true);
			}

		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
