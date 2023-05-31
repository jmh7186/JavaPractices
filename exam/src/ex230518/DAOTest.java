package ex230518;

import java.sql.PreparedStatement;

public class DAOTest {

	public static void main(String[] args) {
		BoardDAO bdao = new BoardDAO();
		MembersDAO memdao = new MembersDAO();
		
		
//		memdao.insertData("hong1", "12341", "010-1111-1111", "010010-1111111", "서울", "hong1@gmail.com", "홍길동1");
//		memdao.insertData("hong2", "12342", "010-1111-1112", "010010-1111112", "경기", "hong2@gmail.com", "홍길동2");
//		memdao.insertData("hong3", "12343", "010-1111-1113", "010010-1111113", "인천", "hong3@gmail.com", "홍길동3");
//		memdao.insertData("hong4", "12344", "010-1111-1114", "010010-1111114", "천안", "hong4@gmail.com", "홍길동4");
		
//		bdao.insertData(1, "제목1", "홍길동1", "내용1", "2023-05-18");
//		bdao.insertData(2, "제목2", "홍길동2", "내용2", "2023-05-18");
//		bdao.insertData(3, "제목3", "홍길동3", "내용3", "2023-05-18");
//		bdao.insertData(4, "제목4", "홍길동4", "내용4", "2023-05-18");
		bdao.insertData(5, "제목5", "홍길동4", "내용5", "sysdate");
		
//		bdao.updateData("bcontent", "수정된 내용", "bid", "4");
	}

}
