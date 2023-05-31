package ex230517;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 기존) createStatement() -> Statement
// 개선) prepareStatement() -> PreparedStatement
// prepareStatement 함수는 호출 시 사전에 작성한 sql문을 입력값으로 주어야 한다.
// 그 다음 미완성된 sql문을 set 함수를 이용하여 완성할 수 있다.
public class PhonebookDAO2 {
	Connection conn;
	PreparedStatement pstat;

	// DB 접속
	public PhonebookDAO2() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터 입력
	public int insertData(int id, String name, String tel, String memo) {
		try {
			pstat = conn.prepareStatement("insert into phonebook values(?,?,?,?)");
			pstat.setInt(1, id);
			pstat.setString(2, name);
			pstat.setString(3, tel);
			pstat.setString(4, memo);
			return pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// 전체출력
	public List<PhonebookVO> findAllData() {
		List<PhonebookVO> pblis = new ArrayList<PhonebookVO>();
		try {
			pstat = conn.prepareStatement("select * from phonebook");
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				pblis.add(new PhonebookVO(rs.getInt("id"), rs.getString("name"), rs.getString("tel"),
						rs.getString("memo")));
			}
			return pblis;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 선택출력
	public List<PhonebookVO> findData(int id) {
		List<PhonebookVO> pblis = new ArrayList<PhonebookVO>();
		try {
			pstat = conn.prepareStatement("select * from phonebook where id=?");
			pstat.setInt(1, id);
			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {
				pblis.add(new PhonebookVO(rs.getInt("id"), rs.getString("name"), rs.getString("tel"),
						rs.getString("memo")));
				return pblis;
			} else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 수정
	public int updateData(int whereid, String name, String tel, String memo) {
		try {
			pstat = conn.prepareStatement("update phonebook set name=?, tel=?, memo=? where id=?");
			pstat.setString(1, name);
			pstat.setString(2, tel);
			pstat.setString(3, memo);
			pstat.setInt(4, whereid);
			return pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// 삭제
	public int deleteData(int id) {
		try {
			pstat = conn.prepareStatement("delete from phonebook where id=?");
			pstat.setInt(1, id);
			return pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
