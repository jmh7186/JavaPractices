package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import vo.BoardVO;

public interface BoardDAOInter {
	
	public List<BoardVO> findAll();
	
	public BoardVO findOneById(int idx);
	
	public int deleteById(int idx);
	
	
	public List<BoardVO> findPage (int currentPage, int countPerPage);
	
	public int totalCount();

	int insert(HttpServletRequest request);

	int updateById(HttpServletRequest request);

	int replyInsert(HttpServletRequest request);
}
