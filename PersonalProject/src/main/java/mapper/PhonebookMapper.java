package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import vo.MemberVO;
import vo.PhonebookVO;

public interface PhonebookMapper {
	public int insert(PhonebookVO pb);

	public List<PhonebookVO> findAll();

	public PhonebookVO findById(String idx);

	public int updateById(PhonebookVO pb);

	public int deleteById(String idx);

	public int totalCount();

	public List<PhonebookVO> rowSelect(@Param("currentPage") int currentPage, @Param("countPerPage") int countPerPage);
}
