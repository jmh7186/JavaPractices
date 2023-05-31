package ex230331;
class AAA implements ABC{
	public void aaa() {
		System.out.println("aaa");
	}
}
class BBB implements ABC{
	public void bbb() {
		System.out.println("bbb");
	}
}
class CCC implements ABC{
	public void ccc() {
		System.out.println("ccc");
	}
}

interface ABC{
	default void aaa() {}
	default void bbb() {}
	default void ccc() {}
}


public class Main8 {

	public static void main(String[] args) {
//		AAA a=new AAA();
//		BBB b=new BBB();
//		CCC c=new CCC();
//		a.aaa();b.bbb();c.ccc();
		ABC abc=new CCC();
		abc.aaa();
		abc.bbb();
		abc.ccc();
	}

}
