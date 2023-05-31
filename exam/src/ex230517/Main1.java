package ex230517;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main1 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		
		Statement stat = conn.createStatement();
		
		ResultSet result = stat.executeQuery("select * from phonebook");
		//배열 사용(공간사용 비효율적)
		PhonebookVO[] pvo = new PhonebookVO[10];
		int i=0;
		while(result.next()) {
			pvo[i++] = new PhonebookVO(result.getInt("id"), result.getString("name"), result.getString("tel"), result.getString("memo"));
		}
		
		for(int j=0; j<pvo.length; j++) {
			System.out.println(pvo[j].toString());
		}

	}

}
