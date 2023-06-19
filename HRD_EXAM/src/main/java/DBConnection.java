import java.sql.Connection;
import java.sql.DriverManager;

//싱글톤 프로그래밍
public class DBConnection {
	private static Connection conn;

	public static Connection getConnection() {
		if (conn != null) {
			return conn;
		} else {
			try {
				if (conn == null) {
					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
					return conn;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return conn;
		}
	}
	
	public DBConnection() {
//		try {
//			if (conn == null) {
//				Class.forName("oracle.jdbc.OracleDriver");
//				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
//				System.out.println("Connection 객체 생성");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
