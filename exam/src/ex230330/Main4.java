package ex230330;
class Test2{
	static int p=1000;
	public static void print() {
		System.out.println("hello");
	}
}

class Color{
	final static int RED=1;
	final static int GREEN=2;
	final static int BLUE=3;
	
}
public class Main4 {

	public static void main(String[] args) {
		/*
		Test2 t=new Test2();
		System.out.println(t.p);
		t.print();
		*/
//		System.out.println(Test2.p);
//		Test2.print();
		int color=1;
		Color.RED=3;
		if(color==Color.RED) {
			System.out.println("»¡°£»ö");
		}else if(color==Color.GREEN) {
			System.out.println("³ì»ö");
		}else if(color==Color.BLUE) {
			System.out.println("ÆÄ¶õ»ö");
		}
		
		

	}

}
