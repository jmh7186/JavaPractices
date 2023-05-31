package ex230427;

class Test implements Cloneable { //객체를 복사할 수 있게 해주는 인터페이스
	String name;
	
	@Override
	protected Test clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Test) super.clone();
	}
}

public class Main6 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Test t1=new Test();
		t1.name="t1";
		
		Test t2=t1;
		System.out.println(t1.name);
		System.out.println(t2.name);
		t2.name="t2";
		System.out.println(t1.name);
		System.out.println(t2.name);
		
		Test t3=(Test) t1.clone();
		System.out.println(t3.name);
		t3.name="111111111";
		System.out.println(t3.name);
	
	}

}
