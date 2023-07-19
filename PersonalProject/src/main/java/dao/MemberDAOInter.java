package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vo.MemberVO;

@Repository
public interface MemberDAOInter {
	public int insert(MemberVO member);

	public List<MemberVO> findAll();

	public MemberVO findById(String id);

	public int updateById(MemberVO m);

	public int deleteById(String id);
}
