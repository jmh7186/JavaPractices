package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstat;
	public static final int VALUE_INSERTED = 1; //정상입력됨
	public static final int VALUE_NULL = 2; //값 비어있음
	public static final int VALUE_NOT_FOUND = 3; //값 찾을 수 없음
	public static final int VALUE_DUPLICATED = 4; //값 중복됨

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
		return 0; // 오류발생
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

	public int updateById(MemberVO m) {
		try {
			String id = m.getId();
			String pwd = m.getPwd();
			String hp = m.getHp();
			String adr = m.getAdr();
			PreparedStatement pstat = conn.prepareStatement("select * from member where mid=?");
			pstat.setString(1, m.getId());
			ResultSet rs = pstat.executeQuery();
			rs = pstat.executeQuery();
			if (rs.next()) {
				pstat = conn.prepareStatement("update member set mpwd=?,mhp=?,madr=? where mid=?");
				pstat.setString(1, pwd);
				pstat.setString(2, hp);
				pstat.setString(3, adr);
				pstat.setString(4, id);
				int result = pstat.executeUpdate();
				rs.close();
				pstat.close();
				return result;
			} else {
				rs.close();
				pstat.close();
				return VALUE_NOT_FOUND;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteById(String id) {
		try {
			if (id.equals("")) {
				return VALUE_NULL;
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
				return VALUE_NOT_FOUND;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
