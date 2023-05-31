package test230502;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Agent {
	public Agent() {
		// TODO Auto-generated constructor stub
	}

	public void serLog() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			Statement stmt = conn.createStatement();
			String sql = "select * from logtable where kind='server'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("contime"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}

	}

	public void cliLog() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			Statement stmt = conn.createStatement();
			String sql = "select * from logtable where kind='client'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("contime"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}

	public void serCnt() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			Statement stmt = conn.createStatement();
			String sql = "select count(*) as count from logtable where kind='server'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("서버 총 접속 횟수:" + rs.getInt("count"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}

	public void cliCnt() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			Statement stmt = conn.createStatement();
			String sql = "select count(*) as count from logtable where kind='client'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("클라이언트 총 접속 횟수:" + rs.getInt("count"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}

	public int menu() throws IOException {
		System.out.println("1. 서버 접속시간 확인");
		System.out.println("2. 클라 접속시간 확인");
		System.out.println("3. 서버 접속횟수 확인");
		System.out.println("4. 클라 접속횟수 확인");
		System.out.println("0. 에이전트 종료");
		int sel = System.in.read() - 48;

		while (System.in.available() != 0) {
			System.in.read();
		}

		return sel;
	}
}

public class AgentMain {

	public static void main(String[] args) throws IOException {
		Agent ag = new Agent();
		while (true) {
			switch (ag.menu()) {
			case 1:
				ag.serLog();
				break;
			case 2:
				ag.cliLog();
				break;
			case 3:
				ag.serCnt();
				break;
			case 4:
				ag.cliCnt();
				break;
			case 0:
				System.out.println("에이전트 종료");
				System.exit(0);
				break;
			default:
				System.out.println("다시 입력하세요.");
				break;
			}
			
			System.in.read();
			System.in.read();
		}

	}

}
