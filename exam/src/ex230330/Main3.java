package ex230330;

class Test1{
	int a;
	
	public void test(Test1 t) {
		System.out.println(t.hashCode());
	}
}

public class Main3 {

	public static void main(String[] args) {
		Test1 t1=new Test1(); //t1=1000번지
		Test1 t2=new Test1();
		Test1 t3=new Test1();
		t1.a=100;
		t2.a=100;
		t3.a=100;
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		System.out.println(t3.hashCode());
		t3.test(t1);
		// "hello"->1000번지가르키고 있다.
		/*
		String s1="hello";
		String s2="hello";
		String s3="hello";
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		*/
	}

}
