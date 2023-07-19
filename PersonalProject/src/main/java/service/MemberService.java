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
	
	public int insert(MemberVO member) {
		return mapper.insert(member);
	}

	public List<MemberVO> findAll() {
		return mapper.findAll();
	}

	public MemberVO findById(String id) {
		return mapper.findById(id);
	}

	public int updateById(MemberVO member) {
		return mapper.updateById(member);
	}

	public int deleteById(String id) {
		return mapper.deleteById(id);
	}

}
