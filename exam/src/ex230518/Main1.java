package ex230518;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ex230517.PhonebookDAO;

public class Main1 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		Statement stat = conn.createStatement();
		
		ResultSet rs = stat.executeQuery("select * from phonebook");
		List<MembersVO> memlis = new ArrayList<MembersVO>();
		while(rs.next()) {
			memlis.add(new MembersVO(rs.getString("id"), rs.getString("password"), rs.getString("tel"), rs.getString("rrn"), rs.getString("address"), rs.getString("email"), rs.getString("username")));
		}
		
		rs = stat.executeQuery("select * from board");
		List<BoardVO> borlis = new ArrayList<BoardVO>();
		while(rs.next()) {
			borlis.add(new BoardVO(rs.getInt("bid"), rs.getString("btitle"), rs.getString("bauthor"), rs.getString("bcontent"), rs.getString("bdate")));
		}
	
		for(int i=0;i<memlis.size();i++) {
			System.out.println(memlis.get(i).getUsername());
		}
		for(int i=0;i<borlis.size();i++) {
			System.out.println(borlis.get(i).getBtitle());
		}
		
	}

}
