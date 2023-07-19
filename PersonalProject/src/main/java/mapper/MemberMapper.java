package mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import vo.MemberVO;

public interface MemberMapper {
	public int insert(MemberVO m);

	public List<MemberVO> findAll();

	public MemberVO findById(String id);

	public int updateById(MemberVO m);

	public int deleteById(String id);
}
