package ex230324;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		/* 
		 *****
		 *****
		 *****
		 *****
		*/
		for(int i=1;i<21;i++) {
		System.out.print("*");
		//5번째 별을 찍은 후 줄바뀜이 생김
		if(i%5==0) {System.out.println();}
		}
		
		/* 
		 12345
		 678910
		 1112131415
		 1617181920
		*/
		for(int i=1;i<21;i++) {
			System.out.print(i);
			if(i%5==0) {System.out.println();}
		}
		
		/* 
		 01234
		 56789
		 1011121314
		 1516171819
		*/

		for(int i=0;i<20;i++) {
			System.out.print(i);
			if(i==0) {continue; }
			if(i%5==0) {System.out.println();}	
		}
		
		System.out.println();
		
		for(int i=0;i<20;i++) {
			if(i!=0) {if(i%5==0) {System.out.println();}}
			System.out.print(i);
		}
		System.out.println();
		
		/* 
		 *****
		 *****
		 *****
		 *****
		*/
		
		for(int j=0;j<4;j++) {
			for(int i=0;i<5;i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 2단에서 9단까지 출력하세요.
		for(int dan=2;dan<10;dan++) {
		for(int i=1;i<10;i++) {
			System.out.printf("%d*%d=%d",dan,i,dan*i);
		}
		System.out.println();
		}
		
		
		//응용문제) 점수를 입력받고 받은 점수가 79점이면 *을 7개 출력, 
		//90점이면 9개를 출력되는 프로그램을 만드시오.
		//hint)Scanner, 연산, 연산것을 반복활용
		Scanner scan=new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		int jumsu=scan.nextInt();
		
		int cnt=jumsu/10;
		
		for(int i=0;i<cnt;i++) {
			System.out.print("*");
		}
		
		//구구단의 단을 입력받아 입력받은 단에 대해 출력하세요.
		System.out.println("단을 입력하세요.");
		int dan=scan.nextInt();
		
		for(int i=1;i<10;i++) {
			System.out.printf("%d*%d=%d\n",dan,i,dan*i);
		}
				
	}

}
