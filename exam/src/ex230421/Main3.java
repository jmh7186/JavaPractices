package ex230421;
class D{
	E e;
	int j=2000;
	//this´Â °´Ã¼(ÀÚ½ÅÀÇ °´Ã¼)
	public D() {
		E obj=new E(this);
		this.e=obj;
	}
}

class E{
	int i=1000;
	D d;
	
	public E(D d) {
		this.d=d;
	}
}
public class Main3 {

	public static void main(String[] args) {
		D obj=new D();
		System.out.println(obj.e.i);
		System.out.println(obj.e.d.j);
	}

}
