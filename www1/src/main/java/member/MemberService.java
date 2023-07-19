package member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements MemberDAOInter{

	@Autowired
	MemberMapper mapper;
	
	@Override
	public int insert(MemberVO member) {
		return mapper.insert(member);
	}

	@Override
	public List<MemberVO> findAll() {
		return mapper.findAll();
	}

	@Override
	public MemberVO findById(String id) {
		return mapper.findById(id);
	}

	@Override
	public int updateById(MemberVO member) {
		return mapper.updateById(member);
	}

	@Override
	public int deleteById(String id) {
		return mapper.deleteById(id);
	}

}
