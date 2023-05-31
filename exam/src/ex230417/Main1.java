package ex230417;

public class Main1 {

	public static void main(String[] args) {
		String id="20000101";
		String name="ȫ�浿";
		int kor=100; int eng=90; int math=80;
		StringBuffer buf=new StringBuffer();
		buf.append(id);buf.append(" ");
		buf.append(name);buf.append(" ");
		buf.append(kor);buf.append(" ");
		buf.append(eng);buf.append(" ");
		buf.append(math);buf.append("\n");
		System.out.println(buf.toString());
		

	}

}
