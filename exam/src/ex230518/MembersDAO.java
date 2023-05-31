package ex230518;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MembersDAO {
	Connection conn;
	Statement stat;

	// DB ����
	public MembersDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			this.stat = this.conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ������ �Է�
	public int insertData(String id, String password, String tel, String rrn, String address, String email,
			String username) {
		try {
			return stat.executeUpdate("insert into members values('"+id+"','"+password+"','"+tel+"','"+rrn+"','"+address+"','"+email+"','"+username+"')");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	// ��ü���
	public List<MembersVO> findAllData() {
		List<MembersVO> pblis = new ArrayList<MembersVO>();
		try {
			ResultSet rs = stat.executeQuery("select * from members");
			while(rs.next()) {
				pblis.add(new MembersVO(rs.getString("id"),rs.getString("password"),rs.getString("tel"),rs.getString("rrn"),rs.getString("address"),rs.getString("email"),rs.getString("username")));
			}
			return pblis;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//�������
	public List<MembersVO> findData(int id) {
		List<MembersVO> pblis = new ArrayList<MembersVO>();
		try {
			ResultSet rs = stat.executeQuery("select * from members where id="+id);
			if(rs.next()) {
				pblis.add(new MembersVO(rs.getString("id"),rs.getString("password"),rs.getString("tel"),rs.getString("rrn"),rs.getString("address"),rs.getString("email"),rs.getString("username")));
				return pblis;
			}else return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	// ����
	public int updateData(String whatcolumn, String newdata, String wherecolumn, String olddata) {
		try {
			return stat.executeUpdate("update members set "+whatcolumn+"='"+newdata+"' where "+wherecolumn+"='"+olddata+"'");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	// ����
	public int deleteData(int id) {
		try {
			return stat.executeUpdate("delete from members where id="+id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
