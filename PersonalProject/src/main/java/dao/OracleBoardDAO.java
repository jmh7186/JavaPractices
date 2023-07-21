package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mapper.BoardMapper;
import vo.BoardVO;

public class OracleBoardDAO implements BoardMapper{
	//구현사항
	//1. pool 또는 싱글톤 적용
	//2. maven을 통한 라이브러리 관리
	//3. @AutoWire 사용하여 객체 주입 (Spring으로 처리)
	Connection conn;
	
	public OracleBoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//계정 헷갈리지 말것
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","1111");
		} catch (Exception e) {
		}
	}
	
	@Override
	public int insert(HttpServletRequest request) {
		try {
			MultipartRequest mr = new MultipartRequest(request,"C:\\Users\\admin\\Documents\\eclipse-workspace\\replyboard\\src\\main\\webapp\\uploadedFiles",1024*1024*5,"UTF-8",new DefaultFileRenamePolicy());
			BoardVO b = new BoardVO();
			b.setTitle(mr.getParameter("title"));
			b.setContent(mr.getParameter("content"));
			b.setWriteid(mr.getParameter("writeid"));
			b.setWritename(mr.getParameter("writename"));
			if(mr.getFilesystemName("file")!=null) {
				b.setFilename(mr.getFilesystemName("file"));
			}
			PreparedStatement ps = conn.prepareStatement("insert into board values(board_idx_seq.nextval, ?,?,0,0,0,?,?,sysdate,?,0,'일반게시판')");
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getContent());
			ps.setString(3, b.getWriteid());
			ps.setString(4, b.getWritename());
			ps.setString(5, b.getFilename());
			int result = ps.executeUpdate();
			ps.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<BoardVO> findAll() {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from board");
			ResultSet rs = ps.executeQuery();
			List<BoardVO> blis = new ArrayList<BoardVO>();
			while(rs.next()) {
				blis.add(new BoardVO(
							rs.getInt("idx"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getInt("viewcount"),
							rs.getInt("parentid"),
							rs.getInt("tab"),
							rs.getString("writeid"),
							rs.getString("writename"),
							rs.getDate("writeday"),
							rs.getString("filename"),
							rs.getInt("isdel"),
							rs.getString("kind")
						));
			}
			rs.close();
			ps.close();
			return blis;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public BoardVO findOneById(int idx) {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from board where idx=?");
			ps.setInt(1, idx);
			ResultSet rs = ps.executeQuery();
			BoardVO b = null;
			if(rs.next()) {
				b = new BoardVO(
						rs.getInt("idx"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("viewcount"),
						rs.getInt("parentid"),
						rs.getInt("tab"),
						rs.getString("writeid"),
						rs.getString("writename"),
						rs.getDate("writeday"),
						rs.getString("filename"),
						rs.getInt("isdel"),
						rs.getString("kind")
						);
			}
			rs.close();
			ps.close();
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateById(HttpServletRequest request) {
		try {
			MultipartRequest mr = new MultipartRequest(request,"C:\\Users\\admin\\Documents\\eclipse-workspace\\replyboard\\src\\main\\webapp\\uploadedFiles",1024*1024*5,"UTF-8",new DefaultFileRenamePolicy());
			BoardVO b = new BoardVO();
			b.setIdx(Integer.valueOf(mr.getParameter("idx")));
			b.setTitle(mr.getParameter("title"));
			b.setContent(mr.getParameter("content"));
			b.setWriteid(mr.getParameter("writeid"));
			b.setWritename(mr.getParameter("writename"));
			if(mr.getFilesystemName("filename")!=null) {
				b.setFilename(mr.getFilesystemName("filename"));
			}else if(mr.getParameter("filename")!=null) {
				b.setFilename(mr.getParameter("filename"));
			}
			PreparedStatement ps = conn.prepareStatement("update board set title=?, content=?, filename=? where idx=?");
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getContent());
			ps.setString(3, b.getFilename());
			ps.setInt(4, b.getIdx());
			int result = ps.executeUpdate();
			ps.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteById(int idx) {
		try {
			PreparedStatement ps = conn.prepareStatement("update board set isdel=1 where idx=?");
			ps.setInt(1, idx);
			int result = ps.executeUpdate();
			ps.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int replyInsert(HttpServletRequest request) {
		try {
			MultipartRequest mr = new MultipartRequest(request,"C:\\Users\\admin\\Documents\\eclipse-workspace\\replyboard\\src\\main\\webapp\\uploadedFiles",1024*1024*5,"UTF-8",new DefaultFileRenamePolicy());
			PreparedStatement ps = conn.prepareStatement("insert into board values(board_idx_seq.nextval, ?,?,0,?,?,?,?,sysdate,?,0,'일반게시판')");
			BoardVO b = new BoardVO();
			b.setTitle(mr.getParameter("title"));
			b.setContent(mr.getParameter("content"));
			b.setWriteid(mr.getParameter("writename"));
			b.setWritename(mr.getParameter("writename"));
			b.setParentid(Integer.valueOf(mr.getParameter("parentid")));
			b.setTab(Integer.valueOf(mr.getParameter("tab")));
			if(mr.getFilesystemName("filename")!=null) {
				b.setFilename(mr.getFilesystemName("filename"));
			}
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getContent());
			ps.setInt(3, b.getParentid());
			ps.setInt(4, b.getTab());
			ps.setString(5, b.getWriteid());
			ps.setString(6, b.getWritename());
			ps.setString(7, b.getFilename());
			int result = ps.executeUpdate();
			ps.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<BoardVO> findPage(int currentPage, int countPerPage) {
		int endRow = currentPage * countPerPage;
		if (countPerPage<10) {
			endRow = totalCount();
		}
		List<BoardVO> blis = new ArrayList<BoardVO>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from (select rownum num, t.* from (select * from board start with parentid=0 connect by prior idx=parentid order siblings by tab asc,idx desc) t where rownum<=? order by rownum desc) where rownum <= ? order by num asc");
			ps.setInt(1, endRow);
			ps.setInt(2, countPerPage);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				blis.add(new BoardVO(
							rs.getInt("idx"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getInt("viewcount"),
							rs.getInt("parentid"),
							rs.getInt("tab"),
							rs.getString("writeid"),
							rs.getString("writename"),
							rs.getDate("writeday"),
							rs.getString("filename"),
							rs.getInt("isdel"),
							rs.getString("kind")
						));
			}
			rs.close();
			ps.close();
			return blis;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int totalCount() {
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) cnt from board");
			ResultSet rs = ps.executeQuery();
			int result = 0;
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
			rs.close();
			ps.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<BoardVO> findList(String keyword, String kind) {
		List<BoardVO> blis = new ArrayList<BoardVO>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from (select rownum num, t.* from (select * from board start with parentid=0 connect by prior idx=parentid order siblings by tab asc,idx desc) t order by rownum desc) where "+kind+" like ? order by num asc");
			ps.setString(1, "%"+keyword+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				blis.add(new BoardVO(
						rs.getInt("idx"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("viewcount"),
						rs.getInt("parentid"),
						rs.getInt("tab"),
						rs.getString("writeid"),
						rs.getString("writename"),
						rs.getDate("writeday"),
						rs.getString("filename"),
						rs.getInt("isdel"),
						rs.getString("kind")
						));
			}
			rs.close();
			ps.close();
			for (BoardVO b:blis) {
				System.out.println(b.toString());
			}
			return blis;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int totalFindCount(String keyword) {
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) cnt from board where title like ?");
			ps.setString(1, "%"+keyword+"%");
			ResultSet rs = ps.executeQuery();
			int result = 0;
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
			rs.close();
			ps.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int viewcountUp (int idx) {
		try {
			PreparedStatement ps = conn.prepareStatement("update board set viewcount=viewcount+1 where idx=?");
			ps.setInt(1, idx);
			int result = ps.executeUpdate();
			ps.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int uploadFile(HttpServletRequest request) {
		try {
			try {
				MultipartRequest mr = new MultipartRequest(request,"C:\\Users\\admin\\Documents\\eclipse-workspace\\replyboard\\src\\main\\webapp\\uploadedFiles",1024*1024*5,"UTF-8",new DefaultFileRenamePolicy());
				String filename = mr.getFilesystemName("file");
				int idx = Integer.valueOf(mr.getParameter("idx"));
				PreparedStatement ps = conn.prepareStatement("update board set filename=? where idx=?");
				ps.setString(1, filename);
				ps.setInt(2, idx);
				int result = ps.executeUpdate();
				ps.close();
				return result;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
