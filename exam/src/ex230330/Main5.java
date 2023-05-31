package ex230330;
class Test3{
	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		if(a>-1 && a<=100)	this.a = a;
		else {System.out.println("값의 범위가 벗어났습니다."); this.a=0;}
	}
	
	private void print() {
		System.out.println("hello");
	}
	
	public void p() {
		print();
	}
	
}

public class Main5 {

	public static void main(String[] args) {
		Test3 t=new Test3();
		//t.a=200;
		//System.out.println(t.a);
		t.setA(200);
		System.out.println(t.getA());
		t.p();
	}

}
