package ex230421;
/*
class A{
	int i;
	B obj;
}

class B{
	int k;
}
*/

class A{
	int i;
	int j;
	int k;
}
class B{
	A obj;
}
public class Main1 {

	public static void main(String[] args) {
		A a=new A();
		a.i=100;
		a.j=200;
		a.k=300;
		
		B b=new B();
		b.obj=new A();
		//모든결과가 0이 출력
		System.out.println(b.obj.i);
		System.out.println(b.obj.j);
		System.out.println(b.obj.k);
		
		b.obj=a;
		System.out.println(b.obj.i);
		System.out.println(b.obj.j);
		System.out.println(b.obj.k);
		
		b.obj.i=1000;
		
		System.out.println(a.i);
		
		/*
		A obja=new A();
		obja.i=10;
		
		B b=new B();
		b.k=100;
		
		obja.obj=b;
		
		System.out.println(obja.obj.k);
		obja.obj.k=200;
		System.out.println(b.k);
*/
	}

}
