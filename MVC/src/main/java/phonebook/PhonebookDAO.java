package phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhonebookDAO {
	private Connection conn;
	private PreparedStatement pstat;
	private ResultSet rs;
	private String idx;
	private String name;
	private String hp;
	private String company;
	private String email;
	private String birthday;
	private String address;
	private String memo;

	public PhonebookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
		} catch (Exception e) {
			// TODO: handle exception
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
		pstat.setString(6, p.getBirthday());
		pstat.setString(7, p.getMemo());
		return pstat.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int delete(String idx) {
		try {
		int _idx = Integer.valueOf(idx);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		PreparedStatement pstat = conn.prepareStatement("delete phonebook where idx=?");
		pstat.setInt(1, _idx);
		return pstat.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int update(String idx, PhonebookVO newp) {
		try {
		int _idx = Integer.valueOf(idx);
		PhonebookVO p=null;
		pstat = conn.prepareStatement("select * from phonebook where idx=?");
		pstat.setInt(1, _idx);
		rs = pstat.executeQuery();
		if(rs.next()) {
			p = new PhonebookVO(rs.getString("idx"),rs.getString("name"),rs.getString("hp"),rs.getString("company"),rs.getString("email"),rs.getString("address"),rs.getString("birthday"),rs.getString("memo"));
		}else {return 2;}
	
		if (newp.getName()!=null && !(newp.getName().equals(""))) p.setName(newp.getName());
		if (newp.getHp()!=null && !(newp.getHp().equals(""))) p.setHp(newp.getHp());
		if (newp.getCompany()!=null && !(newp.getCompany().equals(""))) p.setCompany(newp.getCompany());
		if (newp.getEmail()!=null && !(newp.getEmail().equals(""))) p.setEmail(newp.getEmail());
		if (newp.getAddress()!=null && !(newp.getAddress().equals(""))) p.setAddress(newp.getAddress());
		if (newp.getBirthday()!=null && !(newp.getBirthday().equals(""))) p.setBirthday(newp.getBirthday());
		if (newp.getMemo()!=null && !(newp.getMemo().equals(""))) p.setMemo(newp.getMemo());
		
		pstat = conn.prepareStatement("update phonebook set name=?,hp=?,company=?,email=?,address=?,birthday=?,memo=? where idx=?");
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
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<PhonebookVO> findAll() {
		try {
			List<PhonebookVO> list = new ArrayList<PhonebookVO>();
			pstat = conn.prepareStatement("select * from phonebook");
			rs = pstat.executeQuery();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			while (rs.next()) {
				idx = rs.getString("idx");
				name = rs.getString("name");
				hp = rs.getString("hp");
				company = rs.getString("company");
				if (company == null)
					company = "-";
				email = rs.getString("email");
				if (email == null)
					email = "-";
				birthday = "-";
				if (rs.getString("birthday") != null) {
					Date _birthday = formatter.parse(rs.getString("birthday"));
					birthday = formatter.format(_birthday);
				}
				address = rs.getString("address");
				if (address == null)
					address = "-";
				memo = rs.getString("memo");
				if (memo == null)
					memo = "-";
				PhonebookVO pb = new PhonebookVO(idx, name, hp, company, email, address, birthday, memo);
				list.add(pb);
			}
			rs.close();
			pstat.close();
			conn.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
