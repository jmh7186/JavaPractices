package test230526;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrintAllDeparts {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		PreparedStatement pstat = conn.prepareStatement("select * from depart");
		ResultSet rs = pstat.executeQuery();
		System.out.println("�μ���ȣ / �μ��̸� / ��ǻ�ʹ���� ");
		while (rs.next()) {
			System.out.println(
				rs.getInt("DP_ID") + "  / " + rs.getString("DP_NAME") + " / " + rs.getString("DP_PCMGR")
			);
		}
	}
}