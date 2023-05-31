package ex230517;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhonebookDAO {
	Connection conn;
	Statement stat;

	// DB 접속
	public PhonebookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			this.stat = this.conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터 입력
	public int insertData(int id, String name, String tel, String memo) {
		try {
			return stat.executeUpdate("insert into phonebook values("+id+",'"+name+"','"+tel+"','"+memo+"')");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	// 전체출력
	public List<PhonebookVO> findAllData() {
		List<PhonebookVO> pblis = new ArrayList<PhonebookVO>();
		try {
			ResultSet rs = stat.executeQuery("select * from phonebook");
			while(rs.next()) {
				pblis.add(new PhonebookVO(rs.getInt("id"),rs.getString("name"),rs.getString("tel"),rs.getString("memo")));
			}
			return pblis;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//선택출력
	public List<PhonebookVO> findData(int id) {
		List<PhonebookVO> pblis = new ArrayList<PhonebookVO>();
		try {
			ResultSet rs = stat.executeQuery("select * from phonebook where id="+id);
			if(rs.next()) {
				pblis.add(new PhonebookVO(rs.getInt("id"),rs.getString("name"),rs.getString("tel"),rs.getString("memo")));
				return pblis;
			}else return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	// 수정
	public int updateData(String whatcolumn, String newdata, String wherecolumn, String olddata) {
		try {
			return stat.executeUpdate("update phonebook set "+whatcolumn+"='"+newdata+"' where "+wherecolumn+"='"+olddata+"'");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	// 삭제
	public int deleteData(int id) {
		try {
			return stat.executeUpdate("delete from phonebook where id="+id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
