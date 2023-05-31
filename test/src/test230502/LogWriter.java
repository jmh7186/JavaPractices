package test230502;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LogWriter {

	public void logServer() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn
		=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		Statement stmt=conn.createStatement();
		
		String sql="select max(id) as maxid from logtable";
		ResultSet rs=stmt.executeQuery(sql);
		int maxid=0;
		if(rs.next()) maxid=rs.getInt("maxid")+1;
		
		sql="insert into logtable values("+maxid+", 'server',sysdate)";
		
		stmt.execute(sql);
		stmt.close();
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public void logClient() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn
			=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			Statement stmt=conn.createStatement();
			
			String sql="select max(id) as maxid from logtable";
			ResultSet rs=stmt.executeQuery(sql);
			int maxid=0;
			if(rs.next()) maxid=rs.getInt("maxid")+1;
			
			sql="insert into logtable values("+maxid+", 'client',sysdate)";
			
			stmt.execute(sql);
			stmt.close();
			conn.close();
			}catch(Exception e) {e.printStackTrace();}
	}
}
