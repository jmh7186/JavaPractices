package member;

import java.util.List;

public interface MemberMapper {
	public int insert(MemberVO m);

	public List<MemberVO> findAll();

	public MemberVO findById(String id);

	public int updateById(MemberVO m);

	public int deleteById(String id);
}
