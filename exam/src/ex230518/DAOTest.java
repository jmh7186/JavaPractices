package ex230518;

import java.sql.PreparedStatement;

public class DAOTest {

	public static void main(String[] args) {
		BoardDAO bdao = new BoardDAO();
		MembersDAO memdao = new MembersDAO();
		
		
//		memdao.insertData("hong1", "12341", "010-1111-1111", "010010-1111111", "����", "hong1@gmail.com", "ȫ�浿1");
//		memdao.insertData("hong2", "12342", "010-1111-1112", "010010-1111112", "���", "hong2@gmail.com", "ȫ�浿2");
//		memdao.insertData("hong3", "12343", "010-1111-1113", "010010-1111113", "��õ", "hong3@gmail.com", "ȫ�浿3");
//		memdao.insertData("hong4", "12344", "010-1111-1114", "010010-1111114", "õ��", "hong4@gmail.com", "ȫ�浿4");
		
//		bdao.insertData(1, "����1", "ȫ�浿1", "����1", "2023-05-18");
//		bdao.insertData(2, "����2", "ȫ�浿2", "����2", "2023-05-18");
//		bdao.insertData(3, "����3", "ȫ�浿3", "����3", "2023-05-18");
//		bdao.insertData(4, "����4", "ȫ�浿4", "����4", "2023-05-18");
		bdao.insertData(5, "����5", "ȫ�浿4", "����5", "sysdate");
		
//		bdao.updateData("bcontent", "������ ����", "bid", "4");
	}

}
