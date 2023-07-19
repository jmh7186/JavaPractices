package service;

import java.util.List;

import vo.PhonebookVO;

public class PhonebookPageList {
	int totalCount; //전체게시물 수 
	int countPerPage; //페이지당 글의 수
	int totalPage; //전체페이지 수
	int startPage; //시작페이지
	int endPage; //끝페이지
	int currentPage;  //현재페이지
	List<PhonebookVO> list;
	
	public PhonebookPageList() {}

	public PhonebookPageList(int totalCount, int countPerPage, int totalPage, int startPage, int endPage, int currentPage, List<PhonebookVO> list) {
		this.totalCount = totalCount;
		this.countPerPage = countPerPage;
		this.totalPage = totalPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<PhonebookVO> getList() {
		return list;
	}

	public void setList(List<PhonebookVO> list) {
		this.list = list;
	}
	
}
