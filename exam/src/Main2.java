
public class Main2 {

	public static void main(String[] args) {
		Func f=new Func();
		f.a();
		//String b=f.b();//"b기능입니다." //돌아오는 값을 변수 담는것
		//System.out.println(f.b()); //돌아오는 값을 바로 출력해서 사용
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
