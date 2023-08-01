package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDemoInsertResultSet {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
		try {
			Class.forName("org.postgresql.Driver");
			String query="select * from emp";
			try(Connection conn=DriverManager.getConnection(url,username,password);
					Statement stm=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)){
				
				ResultSet rs= stm.executeQuery(query);
	
				rs.moveToInsertRow(); //Moving to buffer
				
				rs.updateInt(1, 404);
				rs.updateString(2, "gshi");
				rs.updateDouble(3, 91000);
				
				rs.insertRow();
				rs.moveToCurrentRow();	
				
			}
		}
		catch(Exception  e) {
			e.printStackTrace();
		}

	}

}
