package ex230330;
class P{
	public P() {
	System.out.println("P������ ȣ��");
	}
	
	public P(int x) {
		System.out.println("P ���ڰ� �ִ� ������ ȣ��");
	}
	
}

class C extends P{
	public C() {
		System.out.println("C������ ȣ��");
	}
	public C(int x) {
		super(x); // �θ��� �⺻�����ڰ� ���� ������ �Լ��� ȣ���� �� super()�Լ��� �̿� 
		System.out.println("C ���ڰ� �ִ� ������ ȣ��");
	}
}
public class Main10 {

	public static void main(String[] args) {
		//new C();
		new C(10);
	}

}
