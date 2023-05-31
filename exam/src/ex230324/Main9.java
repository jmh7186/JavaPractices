package ex230324;

import java.util.Scanner;

public class Main9 {

	public static void main(String[] args) {
		/*
		//int pay=100;
		int[] pay= {10,20,30,40,50};
		//변수명 pay[0],pay[1], pay[2],pay[3],pay[4]
		System.out.print(pay[0]);
		System.out.print(pay[1]);
		System.out.print(pay[2]);
		System.out.print(pay[3]);
		System.out.print(pay[4]);
		
		System.out.println();
		for(int i=0;i<5;i++) {
			System.out.print(pay[i]);
		}
		*/
		/*
		 int pay1=10, pay2=20, pay3=30;
		 System.out.println();
		for(int i=0;i<5;i++) {
			System.out.print(pay+i);
		}
		*/
		
		//int[] pay= {10,20,30,40,50}; //new가 필요없음, new 객체={ }
		//int pay[]= {10,20,30,40,50};
		//System.out.println(pay[0]);
		 //int[] pay=new int[20];
		/*
		  int pay[]=new int[20];
		 
		 for(int i=0;i<pay.length;i++) {
			 System.out.print(pay[i]);
		 }
		 */
		
		// 1)100~199까지의 값을 배열 a에 저장하세요.
		//int[] a= {100,101,......,199};
		/*
		int[] a=new int[100];
		for(int i=0;i<a.length;i++) {
			a[i]=100+i;
		}
				
		System.out.println(a[99]);
		*/
		
		//2)불규칙한 데이터 처리
		/*
		int[] a= {20,45,36,85,69,85,78};
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum=sum+a[i];
		}
		System.out.println(sum);
		*/
		
		//문제) 위의 데이터는 프로그램에 값을 직접 입력한 형태이다.
		//만약 콘솔창에 36 85 98 96 78 enter key를 눌러
		//배열에 다음 값을 입력하기 원한다. 
		//배열을 선언하고 위의 값을 배열에 입력받으시오.
		int a[]=new int[10];
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<a.length;i++) {
			a[i]=scan.nextInt();
		}
		
		int sum=0;
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
			sum=sum+a[i];
		}

		System.out.println("합계:"+sum);
	}

}
