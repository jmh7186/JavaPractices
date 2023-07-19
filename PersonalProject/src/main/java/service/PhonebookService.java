package service;

import java.util.List;
import dao.PhonebookOracleDAO;
import vo.PhonebookVO;

public class PhonebookService {
	PhonebookOracleDAO dao = new PhonebookOracleDAO();
//	PhonebookMySqlDAO dao = new PhonebookMySqlDAO();
//	PhonebookDAO dao = new PhonebookMySqlDAO();

	public PhonebookPageList pageList(int currentPage) {
		int countPerPage=10; //�������� ǥ�� ����ó ��
		int totalCount=dao.totalCount(); //�� ����ó ��
		///////////////////////////////////////////////////////
		int totalPage; //��ü������ ��
		if(totalCount%countPerPage==0){
			totalPage=totalCount/countPerPage;	
		}else{
			totalPage=(totalCount/countPerPage)+1;
		}
		///////////////////////////////////////////////////////
//		int currentPage;  //����������
		///////////////////////////////////////////////////////
		int startPage; //���� ����ó ��ȣ
		int endPage; //����ȣ
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
		dao.rowSelect(currentPage, countPerPage);
		return new PhonebookPageList(totalCount, countPerPage, totalPage, startPage, endPage, currentPage, dao.rowSelect(currentPage, countPerPage));
	}

	public List<PhonebookVO> findAll() {
		return dao.findAll();
	}

	public PhonebookVO findOne(String idx) {
		return dao.findOne(idx);
	}

	public int delete(String idx) {
		return dao.delete(idx);
	}

}
