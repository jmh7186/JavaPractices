package ex230330;

class C1{
	String name1="C1Ŭ�����Դϴ�.";
	public void print1() {
		System.out.println(name1);
	}
}

class C2 extends C1{
	String name2="C2Ŭ�����Դϴ�.";
	public void print2() {
		System.out.println(name2);
	}
}
public class Main11 {

	public static void main(String[] args) {
//		C1 c1=new C1();
//		C2 c2=new C2();
//		
//		C2 c=(C2)c1; //�θ� �ڽĹ����� �� �� ���� ����ȯ�� ���Ѿ��Ѵ�.
//		C1 cc=c2;    //�ڽ��� �θ� ������ ������ ���� ����ȯ�� �ʿ����.
//		
//		C1 ccc=new C2();
//		
		C2 cc2=new C2();
		cc2.name1="��������� �ٲپ���";
		C1 cccc=cc2;
		System.out.println(cccc.name1);
		System.out.println(cccc.name2);
		

	}

}
