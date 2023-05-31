package ex230330;

class C1{
	String name1="C1클래스입니다.";
	public void print1() {
		System.out.println(name1);
	}
}

class C2 extends C1{
	String name2="C2클래스입니다.";
	public void print2() {
		System.out.println(name2);
	}
}
public class Main11 {

	public static void main(String[] args) {
//		C1 c1=new C1();
//		C2 c2=new C2();
//		
//		C2 c=(C2)c1; //부모가 자식밑으로 갈 때 강제 형변환을 시켜야한다.
//		C1 cc=c2;    //자식이 부모 밑으로 갈때는 강제 형변환이 필요없다.
//		
//		C1 ccc=new C2();
//		
		C2 cc2=new C2();
		cc2.name1="내마음대로 바꾸었음";
		C1 cccc=cc2;
		System.out.println(cccc.name1);
		System.out.println(cccc.name2);
		

	}

}
