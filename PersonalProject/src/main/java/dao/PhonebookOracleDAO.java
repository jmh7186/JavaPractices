package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import vo.PhonebookVO;

public class PhonebookOracleDAO implements PhonebookDAO{
	private Connection conn;
	private PreparedStatement pstat;

	public PhonebookOracleDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insert(PhonebookVO p) {
		try {
			pstat = conn.prepareStatement("insert into phonebook values(Phonebook_idx_seq.nextval,?,?,?,?,?,?,?)");
			pstat.setString(1, p.getName());
			pstat.setString(2, p.getHp());
			pstat.setString(3, p.getCompany());
			pstat.setString(4, p.getEmail());
			pstat.setString(5, p.getAddress());
			String birthday = p.getBirthday();
			if (birthday == "-")
				birthday = null;
			pstat.setString(6, birthday);
			pstat.setString(7, p.getMemo());
			return pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int delete(String idx) {
		try {
			int _idx = Integer.valueOf(idx);
			pstat = conn.prepareStatement("delete phonebook where idx=?");
			pstat.setInt(1, _idx);
			return pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int update(String idx, PhonebookVO newp) {
		try {
			int _idx = Integer.valueOf(idx);
			PhonebookVO p = null;
			pstat = conn.prepareStatement("select * from phonebook where idx=?");
			pstat.setInt(1, _idx);
			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {
				p = new PhonebookVO(rs.getString("idx"), rs.getString("name"), rs.getString("hp"),
						rs.getString("company"), rs.getString("email"), rs.getString("address"),
						rs.getString("birthday"), rs.getString("memo"));
			} else {
				return 2;
			}

			if (newp.getName() != null && !(newp.getName().equals("")))
				p.setName(newp.getName());
			if (newp.getHp() != null && !(newp.getHp().equals("")))
				p.setHp(newp.getHp());
			if (newp.getCompany() != null && !(newp.getCompany().equals("-")))
				p.setCompany(newp.getCompany());
			if (newp.getEmail() != null && !(newp.getEmail().equals("-")))
				p.setEmail(newp.getEmail());
			if (newp.getAddress() != null && !(newp.getAddress().equals("-")))
				p.setAddress(newp.getAddress());
			if (newp.getBirthday() != null && !(newp.getBirthday().equals("-")))
				p.setBirthday(newp.getBirthday());
			if (newp.getMemo() != null && !(newp.getMemo().equals("-")))
				p.setMemo(newp.getMemo());

			pstat = conn.prepareStatement(
					"update phonebook set name=?,hp=?,company=?,email=?,address=?,birthday=?,memo=? where idx=?");
			pstat.setString(1, p.getName());
			pstat.setString(2, p.getHp());
			pstat.setString(3, p.getCompany());
			pstat.setString(4, p.getEmail());
			pstat.setString(5, p.getAddress());

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date _birthday = formatter.parse(p.getBirthday());
			String newbirthday = formatter.format(_birthday);
			pstat.setString(6, newbirthday);

			pstat.setString(7, p.getMemo());
			pstat.setString(8, idx);
			return pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<PhonebookVO> findAll() {
		try {
			List<PhonebookVO> list = new ArrayList<PhonebookVO>();
			pstat = conn.prepareStatement("select * from phonebook");
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				list.add(new PhonebookVO(rs.getString("idx"), rs.getString("name"), rs.getString("hp"),
						rs.getString("company"), rs.getString("email"), rs.getString("address"),
						rs.getString("birthday"), rs.getString("memo")));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public PhonebookVO findOne(String idx) {
		try {
			pstat = conn.prepareStatement("select * from phonebook where idx=?");
			pstat.setString(1, idx);
			ResultSet rs = pstat.executeQuery();
			PhonebookVO pb = null;
			if (rs.next()) {
				pb = new PhonebookVO(rs.getString("idx"), rs.getString("name"), rs.getString("hp"),
						rs.getString("company"), rs.getString("email"), rs.getString("address"),
						rs.getString("birthday"), rs.getString("memo"));
			}
			return pb;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int totalCount() {
		try {
			pstat = conn.prepareStatement("select count(*) from phonebook");
			ResultSet rs = pstat.executeQuery();
			int cnt = 1;
			if (rs.next()) {
				cnt = rs.getInt("count(*)");
			}
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<PhonebookVO> rowSelect(int currentPage, int countPerPage) {
		try {
			pstat = conn.prepareStatement("select * from (select rownum num, t.* from phonebook t) where num>=? and num<=?");
			int startRow=(currentPage-1)*countPerPage+1;
			int endRow=currentPage*countPerPage;
			pstat.setInt(1, startRow);
			pstat.setInt(2, endRow);
			ResultSet rs = pstat.executeQuery();
			List<PhonebookVO> pblis = new ArrayList<PhonebookVO>();
			while (rs.next()) {
				pblis.add(new PhonebookVO(rs.getString("idx"), rs.getString("name"), rs.getString("hp"),
						rs.getString("company"), rs.getString("email"), rs.getString("address"),
						rs.getString("birthday"), rs.getString("memo")));
			}
			return pblis;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}