package ex230421;

class C{
	int i;
}
public class Main2 {

	public static void main(String[] args) {
		C obj=new C();
		System.out.println(obj.i);
		int i=100;
		obj.i=i;
		System.out.println(obj.i);
		obj.i=1000;
		System.out.println(i);

	}

}
