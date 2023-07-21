package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.MemberMapper;
import vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberMapper mapper;
	
	public int insert(MemberVO m) {
		if(mapper.findById(m.getMid())==null) {
			return mapper.insert(m);
		}
		return -1; // 아이디 중복됨
	}

	public List<MemberVO> findAll() {
		return mapper.findAll();
	}

	public MemberVO findById(String mid) {
		return mapper.findById(mid);
	}

	public int updateById(MemberVO m) {
		return mapper.updateById(m);
	}

	public int deleteById(String mid) {
		return mapper.deleteById(mid);
	}

}
