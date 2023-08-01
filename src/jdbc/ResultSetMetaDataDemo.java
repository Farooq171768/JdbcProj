package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataDemo {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
		
		//result set is also a resource whereas result_set_metadata is not a resource
		try {
			Class.forName("org.postgresql.Driver");
			String query="select * from emp where 1=2";
			try(Connection conn = DriverManager.getConnection(url,username,password);
			Statement stm=conn.createStatement();
			ResultSet rs=stm.executeQuery(query)){
				
				ResultSetMetaData rm =rs.getMetaData();
				int cnt= rm.getColumnCount();
				
				for (int i=0;i<=cnt;i++) {
					System.out.print(rm.getCatalogName(i)+"\t");
					System.out.print(rm.getColumnType(i)+"\t");
					System.out.print(rm.getColumnTypeName(i)+"\t");
					System.out.println(rm.getColumnClassName(i));
				}
				
			}
			catch(SQLException e) {
				System.out.println(e);
			}
			}
		catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}

	}

}
