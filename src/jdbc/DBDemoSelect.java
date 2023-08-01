package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoSelect {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
		
		//result set is also a resource whereas result_set_metadata is not a resource
		try {
			Class.forName("org.postgresql.Driver");
			String query = "select * from emp";
			try(Connection conn = DriverManager.getConnection(url,username,password);
					Statement stm= conn.createStatement();
					ResultSet rs = stm.executeQuery(query);) {
				
				
				
				
				ResultSetMetaData rm = rs.getMetaData();
				int cols=rm.getColumnCount();
				
				for (int i=1;i<=cols;i++) {
					System.out.print(rm.getColumnName(i)+"\t");
				}
				System.out.println();
				
				while(rs.next()) {
					for(int i=1;i<=cols;i++) {
						System.out.print(rs.getString(i)+"\t");
						
					}
					System.out.println();
					
					//retriving using column names
//					System.out.print(rs.getInt("empid")+"\t");
//					System.out.print(rs.getString("ename")+"\t");
//					System.out.print(rs.getDouble("salary"));
//					System.out.println();
					
					//retriving using column positions -----Column position start with 1
//					System.out.print(rs.getString(1)+"\t");
//					System.out.print(rs.getString(2)+"\t");
//					System.out.print(rs.getString(3));
//					System.out.println();
				}
				
				
				
				//System.out.println(cnt +" row(s) deleted");
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}


	}

}
