package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBDemoPrepared2 {
	

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
		
		//result set is also a resource whereas result_set_metadata is not a resource
		try {
			Class.forName("org.postgresql.Driver");
			String query = "select * from emp where empid=?";
			try(Connection conn = DriverManager.getConnection(url,username,password);
			PreparedStatement ps=conn.prepareStatement(query)){
				
				ps.setInt(1, 101);
				ResultSet rs= ps.executeQuery();
				
				ResultSetMetaData rm= rs.getMetaData();
				int cnt= rm.getColumnCount();
				
				for (int i=0;i<=cnt;i++) {
					System.out.print(rm.getColumnName(i)+"\t");
				}
				System.out.println();
				
				while(rs.next()) {
					for(int i=0;i<=cnt;i++) {
						System.out.print(rs.getString(i)+"\t");
					}
					System.out.println();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
}
}