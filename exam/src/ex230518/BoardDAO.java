package ex230518;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	Connection conn;
	Statement stat;

	// DB 접속
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			this.stat = this.conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터 입력
	public int insertData(int bid, String btitle, String bauthor, String bcontent, String bdate) {
		try {
			return stat.executeUpdate("insert into board values("+bid+",'"+btitle+"','"+bauthor+"','"+bcontent+"',"+bdate+")");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	// 전체출력
	public List<BoardVO> findAllData() {
		List<BoardVO> pblis = new ArrayList<BoardVO>();
		try {
			ResultSet rs = stat.executeQuery("select * from board");
			while(rs.next()) {
				pblis.add(new BoardVO(rs.getInt("bid"),rs.getString("btitle"),rs.getString("bauthor"),rs.getString("bcontent"),rs.getString("bdate")));
			}
			return pblis;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//선택출력
	public List<BoardVO> findData(int id) {
		List<BoardVO> pblis = new ArrayList<BoardVO>();
		try {
			ResultSet rs = stat.executeQuery("select * from board where id="+id);
			if(rs.next()) {
				pblis.add(new BoardVO(rs.getInt("bid"),rs.getString("btitle"),rs.getString("bauthor"),rs.getString("bcontent"),rs.getString("bdate")));
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
			return stat.executeUpdate("update board set "+whatcolumn+"='"+newdata+"' where "+wherecolumn+"='"+olddata+"'");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	// 삭제
	public int deleteData(int bid) {
		try {
			return stat.executeUpdate("delete from board where id="+bid);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
