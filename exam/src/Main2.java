
public class Main2 {

	public static void main(String[] args) {
		Func f=new Func();
		f.a();
		//String b=f.b();//"b����Դϴ�." //���ƿ��� ���� ���� ��°�
		//System.out.println(f.b()); //���ƿ��� ���� �ٷ� ����ؼ� ���
		//int c=f.c();
		//System.out.println(c);
		//System.out.println(f.c());
		f.f(100);
		new Func().a();
		new Func().a();
		
		String s="hello";
		System.out.println(s.length());
		System.out.println("hello".length());
	}

}
