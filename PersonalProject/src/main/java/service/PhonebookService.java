package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.PhonebookMapper;
import vo.PhonebookVO;

@Service
public class PhonebookService {
	
	@Autowired
	PhonebookMapper mapper;

	public PhonebookPageList pageList(int currentPage) {
		int countPerPage=10;
		int totalCount=mapper.totalCount();
		int totalPage;
		if(totalCount%countPerPage==0){
			totalPage=totalCount/countPerPage;	
		}else{
			totalPage=(totalCount/countPerPage)+1;
		}
		int startPage;
		int endPage;
		if ( currentPage/10<1 ) {
			startPage=1;
			endPage=10;
		}else {
			startPage=currentPage-(currentPage%10);
			endPage=startPage+10;
		}
		if(endPage>totalPage){
			endPage=totalPage;
		}
		return new PhonebookPageList(totalCount, countPerPage, totalPage, startPage, endPage, currentPage, mapper.rowSelect(currentPage, countPerPage));
	}

	public List<PhonebookVO> findAll() {
		return mapper.findAll();
	}

	public PhonebookVO findById(String idx) {
		return mapper.findById(idx);
	}

	public int deleteById(String idx) {
		return mapper.deleteById(idx);
	}

}
