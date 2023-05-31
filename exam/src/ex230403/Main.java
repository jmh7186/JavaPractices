package ex230403;

class A{
	
}
class B extends A{
	
}
class C extends B{
	
}

interface AInter{
	public void a();
}
interface BInter{
	public void b();
}
interface CInter extends AInter,BInter{
	
}

class D implements CInter{

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void b() {
		// TODO Auto-generated method stub
		
	}
	
}

abstract class E{
	public abstract void e();
}
//extends는 확장의 의미를 가지고 있지만 추상클래스의 추상함수는 확장할 수 없음
interface EInter extends E{
	
}
public class Main {

	public static void main(String[] args) {
		int a=10;
		int b=20;
		int imsi;
		imsi=a;
		a=b;
		b=imsi;
	}

}
