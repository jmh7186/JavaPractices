package dao;

import java.util.List;

import vo.PhonebookVO;

public interface PhonebookDAO {
	//입력
	//public int insert(PhonebookVO pb);
	
	//전체출력
	public List<PhonebookVO> findAll ();
	
	//선택출력
	public PhonebookVO findOne (String idx);
	
	//검색
	//public List<PhonebookVO> findByKeyword (String keyword, String column);
	
	//페이지 출력
	public List<PhonebookVO> rowSelect (int startNum, int endNum);
	
	//수정
	//public int updateById (String idx);
	
	//삭제
	//public int deleteById (String idx);
	
	//전체 게시물 수 확인
	public int totalCount ();
}
