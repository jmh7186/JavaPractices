package myprotocol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgentMain {

	public static void main(String[] args) {
		//1.서버의 로그기록 확인
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection conn
//			=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
//			Statement stmt=conn.createStatement();
//			String sql="select * from logtable where kind='server'";
//			ResultSet rs=stmt.executeQuery(sql);
//			while(rs.next()) {
//				System.out.println(rs.getString("contime"));
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		}catch(Exception e) {}
		//2.클라이언트의 로그기록 확인
		
		//3.서버의 접속횟수 확인
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn
			=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			Statement stmt=conn.createStatement();
			String sql="select count(*) as count from logtable where kind='server'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("서버총접속횟수:"+rs.getInt("count"));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {}
		//4.클라이언의 접속횟수 확인

	}

}
