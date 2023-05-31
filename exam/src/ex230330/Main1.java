package ex230330;

class Test{
	int a;
	char c;
	float f;
	String s;
	public Test() {
		a=100;
		c='a';
		f=3.14f;
		s="hello";
	}
	public Test(int a, char c, float f, String s) {
		this.a = a;
		this.c = c;
		this.f = f;
		this.s = s;
	}
	
	public int returnint() {
		return 1000;
	}
	
	public char returnchar() {
		return 'a';
	}
	
	public float returnfloat() {
		return 3.14f;
	}
	
	public String returnString() {
		return "hello";
	}
}

public class Main1 {

	public static void main(String[] args) {
		//Test t=new Test();
		//현재 만들어진 객체에 변수가 4개 존재, 이 변수에는 값이 없는 상태
		//Test t=new Test(1,'c',0.1f,"java");
		int aa=1000;
		char cc='f';
		float ff=1.1f;
		String ss="html";
		//Test t=new Test(aa,cc,ff,ss);//new Test(1000, 'f', 1.1f, "html")
		Test t=new Test();
		Test t2
		=new Test(t.returnint(), t.returnchar(), t.returnfloat(), t.returnString());
		Test t3
		=new Test(10000, t.returnchar(), ff, "hello"+"java");
		
		System.out.println(t.a);
		System.out.println(t.c);
		System.out.println(t.f);
		System.out.println(t.s);
		Test t1 = null;
		System.out.println(t1);
		

	}

}
