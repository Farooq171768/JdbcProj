package jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDemoSelectBinary {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/cgg_interns";
		String username="postgres";
		String password ="farooq14";
		
		try {
			Class.forName("org.postgresql.Driver");
			String cmd="select filedata from attachment where id=?";
			try(Connection conn= DriverManager.getConnection(url,username,password);
					PreparedStatement ps= conn.prepareStatement(cmd);){
				
				ps.setInt(1, Integer.parseInt(args[0]));
				
				ResultSet rs= ps.executeQuery();
				
				String saveDir="./temp";
				
				 while(rs.next()) {
					 String fileName= rs.getString("fileename");
					 
					 File file =new File(saveDir,fileName);
					 FileOutputStream fos= new FileOutputStream(file);
					 byte [] data = rs.getBytes("filedata");
					 fos.write(data);
					 fos.flush();
					 fos.close();
					 
					 System.out.println("File saved as " + file.getCanonicalPath());
					 
					 
				 }
				 rs.close();
			}
		}
			catch(ClassNotFoundException| SQLException| IOException e) {
				e.printStackTrace();
			}
	}
}
