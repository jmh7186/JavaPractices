package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HrdDAO {
	Connection conn;
	PreparedStatement ps;

	public HrdDAO() {
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:/pool");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insert(HRD_MemberVO m) {
		try {
			ps = conn.prepareStatement("insert into member_tbl_02 values(member_tbl_02_custno_seq.nextval,?,?,?,?,?,?)");
			ps.setString(1, m.getCustname());
			ps.setString(2, m.getPhone());
			ps.setString(3, m.getAddress());
			ps.setString(4, m.getJoindate());
			ps.setString(5, m.getGrade());
			ps.setString(6, m.getCity());
			int result = ps.executeUpdate();
			ps.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<HRD_MemberVO> findAll() {
		try {
			ps = conn.prepareStatement("select * from member_tbl_02 order by custno asc");
			ResultSet rs = ps.executeQuery();
			List<HRD_MemberVO> lis = new ArrayList<HRD_MemberVO>();
			while (rs.next()) {
				lis.add(new HRD_MemberVO(rs.getString("custno"), rs.getString("custname"), rs.getString("phone"),
						rs.getString("address"), rs.getString("joindate"), rs.getString("grade"),
						String.valueOf(rs.getInt("city"))));
			}
			rs.close();
			ps.close();
			conn.close();
			return lis;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public HRD_MemberVO findOne(String custname) {
		try {
			ps = conn.prepareStatement("select * from member_tbl_02 where custno=?");
			ps.setString(1, custname);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				HRD_MemberVO m = new HRD_MemberVO(rs.getString("custno"), rs.getString("custname"), rs.getString("phone"),
						rs.getString("address"), rs.getString("joindate"), rs.getString("grade"), rs.getString("city"));
				rs.close();
				ps.close();
				conn.close();
				return m;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public HRD_MemberVO memberCount() {
		try {
			ps = conn.prepareStatement("select max(custno)+1 as num, sysdate from member_tbl_02");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				HRD_MemberVO m = new HRD_MemberVO();
				m.setCustno(rs.getString("num"));
				m.setJoindate(rs.getString("sysdate"));
				rs.close();
				ps.close();
				conn.close();
				return m;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public List<HRD_MemberVO> findSales() {
		try {
			ps = conn.prepareStatement("select MEMBER.CUSTNO, MEMBER.CUSTNAME, MEMBER.GRADE, sum(MONEY.PRICE) SALES from MEMBER_TBL_02 MEMBER, MONEY_TBL_02 MONEY where MEMBER.CUSTNO=MONEY.CUSTNO and PRICE is not null group by MEMBER.CUSTNO, MEMBER.CUSTNAME, MEMBER.GRADE order by SALES desc");
			ResultSet rs = ps.executeQuery();
			List<HRD_MemberVO> lis = new ArrayList<HRD_MemberVO>();
			while (rs.next()) {
				HRD_MemberVO m = new HRD_MemberVO();
				m.setCustno(rs.getString("custno"));
				m.setCustname(rs.getString("custname"));
				m.setGrade(rs.getString("grade"));
				m.setSales(rs.getString("Sales"));
				lis.add(m);
			}
			rs.close();
			ps.close();
			conn.close();
			return lis;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int update(HRD_MemberVO m) {
		try {
			ps = conn.prepareStatement("update member_tbl_02 set custname=?, phone=?, address=?, grade=?, city=? where custno=?");
			ps.setString(1, m.getCustname());
			ps.setString(2, m.getPhone());
			ps.setString(3, m.getAddress());
			ps.setString(4, m.getGrade());
			ps.setString(5, m.getCity());
			ps.setString(6, m.getCustno());
			int result = ps.executeUpdate();
			ps.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
