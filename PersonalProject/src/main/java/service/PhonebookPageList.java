package service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vo.PhonebookVO;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PhonebookPageList {
	int totalCount; //전체게시물 수 
	int countPerPage; //페이지당 글의 수
	int totalPage; //전체페이지 수
	int startPage; //시작페이지
	int endPage; //끝페이지
	int currentPage;  //현재페이지
	List<PhonebookVO> list;
}
