package member;

import java.util.List;

public interface MemberDAOInter {
	public int insert(MemberVO member);

	public List<MemberVO> findAll();

	public MemberVO findById(String id);

	public int updateById(MemberVO m);

	public int deleteById(String id);
}
