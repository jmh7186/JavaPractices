package service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import dao.OracleBoardDAO;
import vo.BoardVO;


public class BoardService {
	OracleBoardDAO dao = new OracleBoardDAO();
	
	public BoardPageList pageList(int currentPage, int countPerPage) {
		int totalPage = 1;
		int totalCount = dao.totalCount();
		if (totalCount%countPerPage!=0) {
			totalPage = totalCount/countPerPage+1;
		} else {
			totalPage = totalCount/countPerPage;
		}
		int startPage;
		int endPage;
		if ( currentPage/5<1 ) {
			startPage=1;
			endPage=5;
		}else {
			startPage=currentPage-(currentPage%5);
			endPage=startPage+5;
		}
		if(endPage>totalPage){
			endPage=totalPage;
		}
		if(totalPage == currentPage) {
			countPerPage = totalCount%countPerPage;
		}
		BoardPageList pl = new BoardPageList(totalCount, countPerPage, totalPage, startPage, endPage, currentPage, dao.findPage(currentPage, countPerPage));
		return pl;
	}
	
	public List<BoardVO> findList(String keyword, String kind) {
		return dao.findList(keyword, kind);
	}

	public BoardVO findOneById(int idx) {
		return dao.findOneById(idx);
	}

	public int viewcountUp(int idx) {
		return dao.viewcountUp(idx);
	}
	
	public int uploadFile(HttpServletRequest request) {
		return dao.uploadFile(request);
	}

	public int insert(HttpServletRequest request) {
		return dao.insert(request);
	}

	public int updateById(HttpServletRequest request) {
		return dao.updateById(request);
		
	}

	public int deleteById(int idx) {
		return dao.deleteById(idx);
	}

	public int replyInsert(HttpServletRequest request) {
		return dao.replyInsert(request);
	}
}
