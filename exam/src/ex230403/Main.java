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
//extends�� Ȯ���� �ǹ̸� ������ ������ �߻�Ŭ������ �߻��Լ��� Ȯ���� �� ����
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
