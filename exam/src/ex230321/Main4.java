package ex230321;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		/*
		System.out.println(3/2);
		float result=3.0f/2;
		result=3/2.0f;
		System.out.println(result);
		System.out.println((float)3/2);
		 */
		
		//클래스를 만들고 단순한 테스트를 하기 위한 코드
		/*
		Cal cal=new Cal();
		System.out.println(cal.add(200,100));
		System.out.println(cal.minus(200,100));
		System.out.println(cal.mux(200,100));
		System.out.println(cal.div(300,100));
		*/
		
		//두 수를 입력받아 클래스의 기능을 이용하여 사칙연산을 하세요.
		Cal cal=new Cal();
		int su1, su2;
		Scanner scan=new Scanner(System.in);
		
		System.out.println("계산할 첫번째 수를 입력하세요");
		su1=scan.nextInt();
		
		System.out.println("계산할 두번째 수를 입력하세요");
		su2=scan.nextInt();
		
		System.out.println("두 수의 합:"+cal.add(su1, su2));
		System.out.println("두 수의 차:"+cal.minus(su1, su2));
		System.out.println("두 수의 곱:"+cal.mux(su1, su2));
		System.out.println("두 수의 나누기:"+cal.div(su1, su2));
	}

}
