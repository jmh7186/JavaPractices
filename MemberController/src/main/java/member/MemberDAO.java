package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstat;
	public static final int VALUE_INSERTED = 1;
	public static final int VALUE_NULL = 2;
	public static final int VALUE_NOT_FOUND = 3;
	public static final int VALUE_DUPLICATED = 4;

	public MemberDAO() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "1234");
	}

	public int insert(MemberVO member) {
		try {
			if (member.getId().equals("") || member.getPwd().equals("") || member.getHp().equals("")) {
				return VALUE_NULL;
			}
			pstat = conn.prepareStatement("select mid from member");
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				if (member.getId().equals(rs.getString("mid"))) {
					return VALUE_DUPLICATED;
				}
			}

			pstat = conn.prepareStatement("insert into member values(?,?,?,?)");
			pstat.setString(1, member.getId());
			pstat.setString(2, member.getPwd());
			pstat.setString(3, member.getHp());
			pstat.setString(4, member.getAdr());
			int result = pstat.executeUpdate();
			rs.close();
			pstat.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0; // 오류
	}

	public List<MemberVO> findAll() {
		try {
			PreparedStatement pstat = conn.prepareStatement("select * from member");
			ResultSet rs = pstat.executeQuery();
			List<MemberVO> mls = new ArrayList<MemberVO>();
			while (rs.next()) {
				mls.add(new MemberVO(rs.getString("mid"), rs.getString("mpwd"), rs.getString("mhp"),
						rs.getString("madr")));
			}
			rs.close();
			pstat.close();
			return mls;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public MemberVO findById(String id) {
		try {
			PreparedStatement pstat = conn.prepareStatement("select * from member where mid=?");
			pstat.setString(1, id);
			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {
				MemberVO m = new MemberVO(rs.getString("mid"), rs.getString("mpwd"), rs.getString("mhp"),
						rs.getString("madr"));
				rs.close();
				pstat.close();
				return m;
			} else {
				return null; // 값 찾을 수 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateById(String keyword, String id, String pwd, String hp, String adr) {
		try {
			if (keyword.equals("")) {
				return VALUE_NULL; // 값 비어있음
			}
			PreparedStatement pstat = conn.prepareStatement("select mid from member");
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				if(rs.getString("mid").equals(id)) {
					rs.close();
					pstat.close();
					return VALUE_DUPLICATED;
				}
			}
			pstat = conn.prepareStatement("select * from member where mid=?");
			pstat.setString(1, keyword);
			rs = pstat.executeQuery();
			if (rs.next()) {
				pstat = conn.prepareStatement("update member set mid=?,mpwd=?,mhp=?,madr=? where mid=?");
				if(id.equals("")) id=rs.getString("mid");
				pstat.setString(1, id);
				if(pwd.equals("")) pwd=rs.getString("mpwd");
				pstat.setString(2, pwd);
				if(hp.equals("")) hp=rs.getString("mhp");
				pstat.setString(3, hp);
				if(adr.equals("")) {
					adr=rs.getString("madr");
				}else if(adr.equals("-")) {
					adr=null;
				}
				pstat.setString(4, adr);
				pstat.setString(5, keyword);
				int result = pstat.executeUpdate();
				rs.close();
				pstat.close();
				return result;
			} else {
				rs.close();
				pstat.close();
				return VALUE_NOT_FOUND; // 값 찾을 수 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteById(String id) {
		try {
			if (id.equals("")) {
				return VALUE_NULL; // 값 비어있음
			}
			PreparedStatement pstat = conn.prepareStatement("select * from member where mid=?");
			pstat.setString(1, id);
			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {
				pstat = conn.prepareStatement("delete member where mid=?");
				pstat.setString(1, id);
				int result = pstat.executeUpdate();
				rs.close();
				pstat.close();
				return result;
			} else {
				rs.close();
				pstat.close();
				return VALUE_NOT_FOUND; // 값 찾을 수 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
