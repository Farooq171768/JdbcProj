package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDemoInsertBinary2 {
	public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/cgg_interns";
	String username="postgres";
	String password ="farooq14";
	
	try {
		Class.forName("org.postgresql.Driver");
		String cmd= "insert into attachment(fileename,filedata) values(?,?)";
		try(Connection conn=DriverManager.getConnection(url,username,password);
				PreparedStatement ps= conn.prepareStatement(cmd,Statement.RETURN_GENERATED_KEYS)){
			
			File file =new File(args[0]);
			String name = file.getName();
			int length = (int)file.length();
			
			ps.setString(1, name);
			
			
			byte [] data= new byte [length];
			FileInputStream source = new FileInputStream(file);
			try {
				source.read(data,0,length);
				source.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			ps.setBytes(2, data);
			int cnt= ps.executeUpdate();
			
			if (cnt>0){
				System.out.println(cnt +"row(s) inserted");
				ResultSet keys =ps.getGeneratedKeys();
				keys.next();
				int generatedkey = keys.getInt(1);
				System.out.println("Id adding" +generatedkey);
				keys.close();
				
			}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
