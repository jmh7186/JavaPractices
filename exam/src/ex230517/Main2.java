package ex230517;

public class Main2 {

	public static void main(String[] args) {
		PhonebookDAO2 pbdao = new PhonebookDAO2();
//		if(pbdao.insertData(11, "aaa", "010-8798-8948", "�޸�11")==1) {
//			System.out.println(pbdao.findAllData());
//		}
//		pbdao.insertData(1, "ȫ�浿1", "010-1111-1111", "�޸�1");
//		pbdao.insertData(2, "ȫ�浿2", "010-1111-1112", "�޸�2");
//		pbdao.insertData(3, "ȫ�浿3", "010-1111-1113", "�޸�3");
//		pbdao.insertData(4, "ȫ�浿4", "010-1111-1114", "�޸�4");
//		pbdao.insertData(5, "ȫ�浿5", "010-1111-1115", "�޸�5");
//		pbdao.insertData(6, "ȫ�浿6", "010-1111-1116", "�޸�6");
//		pbdao.insertData(7, "ȫ�浿7", "010-1111-1117", "�޸�7");
//		pbdao.insertData(8, "ȫ�浿8", "010-1111-1118", "�޸�8");
//		pbdao.insertData(9, "ȫ�浿9", "010-1111-1119", "�޸�9");
//		pbdao.insertData(10, "ȫ�浿10", "010-1111-1110", "�޸�10");
//		pbdao.insertData(11, "null", "null", "null");
//		pbdao.updateData(3, "ȫ�浿", "010-1111-1113", "������3");
//		System.out.println(pbdao.findAllData());
		pbdao.deleteData(11);
		for(int i=0; i<pbdao.findAllData().size(); i++) {
			System.out.println(pbdao.findAllData().get(i));
		}
		System.out.println(pbdao.findData(10));
	}

}
