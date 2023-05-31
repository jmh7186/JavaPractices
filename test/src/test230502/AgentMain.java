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
				System.out.println("���� �� ���� Ƚ��:" + rs.getInt("count"));
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
				System.out.println("Ŭ���̾�Ʈ �� ���� Ƚ��:" + rs.getInt("count"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}

	public int menu() throws IOException {
		System.out.println("1. ���� ���ӽð� Ȯ��");
		System.out.println("2. Ŭ�� ���ӽð� Ȯ��");
		System.out.println("3. ���� ����Ƚ�� Ȯ��");
		System.out.println("4. Ŭ�� ����Ƚ�� Ȯ��");
		System.out.println("0. ������Ʈ ����");
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
				System.out.println("������Ʈ ����");
				System.exit(0);
				break;
			default:
				System.out.println("�ٽ� �Է��ϼ���.");
				break;
			}
			
			System.in.read();
			System.in.read();
		}

	}

}
