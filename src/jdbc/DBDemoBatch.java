package jdbc;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoBatch {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
		try {
			Class.forName("org.postgresql.Driver");
			try(Connection conn=DriverManager.getConnection(url,username,password);
					Statement stm= conn.createStatement()){
				
				stm.addBatch("insert into emp values(304,'dddd',46000)");
				stm.addBatch("insert into emp values(305,'kkk',49000)");
				stm.addBatch("insert into emp values(306,'jjj',65000)");
				
				int [] counts;
				try {
					counts = stm.executeBatch();
				}
				catch(BatchUpdateException e) {
					counts=e.getUpdateCounts();
				}
				
				for (int i=0;i<counts.length;i++) {
					switch(counts[i]) {
					case Statement.SUCCESS_NO_INFO:
						System.out.println("SUCCESS NO INFO");
						break;
					case Statement.EXECUTE_FAILED:
						System.out.println("EXECUYION FAILED");
						break;
					default:
						System.out.println(counts[i]+ " row(s) effected");	
					}
				}
			}
		}
		catch(ClassNotFoundException|SQLException e) {
			System.out.println(e);
		}

	}

}
