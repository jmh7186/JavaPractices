package ex230320;

import java.util.Scanner;

public class InputMain {

	public static void main(String[] args) {
		
		/*
		//학번을 입력하세요.
		String id;
		//자동import를 하기위해 마우스 올려놓았을 때 해당 클래스가 나타나지 않으면
		// ctrl+space 를 눌려 검색
		Scanner scan=new Scanner(System.in);
		
		System.out.print("학번을 입력하세요.");
		id=scan.nextLine();
		System.out.println("입력하신 학번은 "+id+"입니다.");
		*/
		
		//두 수를 입력받으세요.
		// 두 수를 입력받아 더하는 프로그램을 만드세요.
		int su1, su2;
		Scanner scan=new Scanner(System.in);
		
		System.out.print("첫번째 수를 입력하세요.");
		su1=scan.nextInt();
		
		System.out.print("두번째 수를 입력하세요.");
		su2=scan.nextInt();
		
		/*
		int sum;
		sum=su1+su2;
		System.out.println("두 수의 합은 "+sum);
		*/
		
		System.out.println("두 수의 합은 "+(su1+su2));
		
		// 두 수를 입력받아 빼기(나누기, 곱하기) 프로그램을 만드세요.
				
		System.out.println("두 수의 차는 "+(su1-su2));
		System.out.println("두 수의 곱은 "+(su1*su2));
		System.out.println("두 수의 몫은 "+(su1/su2));
		System.out.println("두 수의 나머지는 "+(su1%su2));
		
		//두 수를 입력받아 사칙연산을 모두 사용하여 결과를 출력하세요.

	}

}
