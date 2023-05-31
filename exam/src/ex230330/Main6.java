package ex230330;
class A{
	int a;
	public void aprint() {
		System.out.println("aprint:"+a);
	}
}

class AA extends A{
	
}
public class Main6 {

	public static void main(String[] args) {
	A obj=new A();
	obj.a=100;
	obj.aprint();
	
	AA objAA=new AA();
	objAA.a=1000;
	objAA.aprint();
	}

}
