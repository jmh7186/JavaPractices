package ex230330;
class P{
	public P() {
	System.out.println("P생성자 호출");
	}
	
	public P(int x) {
		System.out.println("P 인자가 있는 생성자 호출");
	}
	
}

class C extends P{
	public C() {
		System.out.println("C생성자 호출");
	}
	public C(int x) {
		super(x); // 부모의 기본생성자가 인자 생성자 함수를 호출할 때 super()함수를 이용 
		System.out.println("C 인자가 있는 생성자 호출");
	}
}
public class Main10 {

	public static void main(String[] args) {
		//new C();
		new C(10);
	}

}
