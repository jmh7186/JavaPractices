package jdbc;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {
	private static Connection conn;
	
	public static Connection getConnection () {
		if (conn != null) {
			return conn;
		}else {
			try {
				// context.xml을 사용하기 위해 initialContext 생성
				Context initContext = new InitialContext();
				// 서버환경에 설정된 환경변수 찾기 (context.xml에서 Resource 태그 읽어옴)
				Context envContext = (Context) initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource) envContext.lookup("jdbc/oracle");
				Connection conn = ds.getConnection();
				return conn;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
