package ex230321;

public class Main2 {

	public static void main(String[] args) {
		//args를 이용하여 문자열을 클래스변수에 넣는 작업
		Cal cal=new Cal();
		cal.su1=Integer.parseInt(args[0]);
		cal.su2=Integer.parseInt(args[1]);
		System.out.println("두 수의 합:"+(cal.su1+cal.su2));

	}

}
