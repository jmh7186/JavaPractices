package ex230525;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws Exception {
//		String kind="name";
//		String search="3";
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
//        PreparedStatement pstat = conn.prepareStatement("select * from phonebook where name like '%'||?||'%' or company like '%'||?||'%' or email like '%'||?||'%' or address like '%'||?||'%' or memo like '%'||?||'%'");
//        pstat.setString(1, search);
//        pstat.setString(2, search);
//        pstat.setString(3, search);
//        pstat.setString(4, search);
//        pstat.setString(5, search);
//        ResultSet rs = pstat.executeQuery();
//        while(rs.next()) {
//        	System.out.println(rs.getString("name"));
//        }
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date _birthday = formatter.parse("2001-03-30 00:00:00");
		String newbirthday = formatter.format(_birthday);
		System.out.println(newbirthday);
	}

}
