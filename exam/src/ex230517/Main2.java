package ex230517;

public class Main2 {

	public static void main(String[] args) {
		PhonebookDAO2 pbdao = new PhonebookDAO2();
//		if(pbdao.insertData(11, "aaa", "010-8798-8948", "¸Þ¸ð11")==1) {
//			System.out.println(pbdao.findAllData());
//		}
//		pbdao.insertData(1, "È«±æµ¿1", "010-1111-1111", "¸Þ¸ð1");
//		pbdao.insertData(2, "È«±æµ¿2", "010-1111-1112", "¸Þ¸ð2");
//		pbdao.insertData(3, "È«±æµ¿3", "010-1111-1113", "¸Þ¸ð3");
//		pbdao.insertData(4, "È«±æµ¿4", "010-1111-1114", "¸Þ¸ð4");
//		pbdao.insertData(5, "È«±æµ¿5", "010-1111-1115", "¸Þ¸ð5");
//		pbdao.insertData(6, "È«±æµ¿6", "010-1111-1116", "¸Þ¸ð6");
//		pbdao.insertData(7, "È«±æµ¿7", "010-1111-1117", "¸Þ¸ð7");
//		pbdao.insertData(8, "È«±æµ¿8", "010-1111-1118", "¸Þ¸ð8");
//		pbdao.insertData(9, "È«±æµ¿9", "010-1111-1119", "¸Þ¸ð9");
//		pbdao.insertData(10, "È«±æµ¿10", "010-1111-1110", "¸Þ¸ð10");
//		pbdao.insertData(11, "null", "null", "null");
//		pbdao.updateData(3, "È«±æµ¿", "010-1111-1113", "¼öÁ¤µÊ3");
//		System.out.println(pbdao.findAllData());
		pbdao.deleteData(11);
		for(int i=0; i<pbdao.findAllData().size(); i++) {
			System.out.println(pbdao.findAllData().get(i));
		}
		System.out.println(pbdao.findData(10));
	}

}
