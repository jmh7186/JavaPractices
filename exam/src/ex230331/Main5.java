package ex230331;
class A implements Print{
	@Override
	public void print() {
		System.out.println("A");
	}
}
class B implements Print{
	@Override
	public void print() {
		System.out.println("B");
	}
}
class C implements Print{
	@Override
	public void print() {
		System.out.println("C");
	}
}
public class Main5 {

	public static void main(String[] args) {
		/*
		B b=new B();
		b.print();
		*/
		Print p=new C();
		p.print();
	}

}
