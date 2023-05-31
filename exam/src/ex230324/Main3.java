package ex230324;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		//홀수 짝수를 판별하세요.
		//문제분석. 어떤값(데이터, 입력값)에 대해 홀수 인지 짝수인지 판별하는가?
		//입력-처리 및 분석-결과를 활용하여 또 다른 출력으로 표시
		/*
		int su=10;
		if(su%2==1) {
			System.out.println("홀수입니다.");
		}else {
			System.out.println("짝수입니다.");
		}
		*/
		
		//추가사항)숫자를 입력받아 홀수인지 짝수인지 판별하세요.
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("홀수 짝수를 판별하기 위한 숫자를 입력하세요.");
		int su=scan.nextInt();
		if(su%2==1) {
			System.out.println("홀수입니다.");
		}else {
			System.out.println("짝수입니다.");
		}
		*/
		//추가사항)1에서 10까지 홀수의 합을 구하세요.(먼저알아야할 사항:1에서10까지 합구하기)
		/*
		int sum=0;
		for(int i=1;i<11;i++) {
			if(i%2==1)	sum=sum+i;
		}
		System.out.println(sum);
		*/
		//추가사항)1에서 10까지 홀수와 짝수의 합을 구하세요.
		/*
		int odd=0;
		int eve=0;
		for(int i=1;i<11;i++) {
			if(i%2==1) odd=odd+i;
			else eve=eve+i;
		}
		System.out.println("홀수의 합:"+odd);
		System.out.println("짝수의 합:"+eve);
		*/
		//입력받은 수가 100일 경우 1에서 100까지를 합하고
		//입력받은 수가 50이면 1에서 50까지의 합을 구하세요.
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int su=scan.nextInt();
		int sum=0;
		for(int i=1;i<=su;i++) {
			sum=sum+i;
		}
		System.out.println(sum);
		*/
		//두 수를 입력받고 입력받은 범위의 합을 구하세요.
		//10 20:입력 -> 10에서 20까지의 합을 구하세요.
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("입력 범위를 입력하세요.예)10 20");
		int su1=scan.nextInt();
		int su2=scan.nextInt();
		int sum=0;
		for(int i=su1;i<=su2;i++) {
			sum=sum+i;
		}
		System.out.println(sum);
		*/
		//위의 코드에 문제가 있음. 무슨문제가 있나요? 20 10
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("입력 범위를 입력하세요.예)10 20");
		int su1=scan.nextInt();
		int su2=scan.nextInt();
		if(su1>su2) {
			//su1과 su2를 교환
			int imsi=su1;
			su1=su2;
			su2=imsi;
		}
		int sum=0;
		for(int i=su1;i<=su2;i++) {
			sum=sum+i;
		}
		System.out.println(sum);
		*/
			
		//입력받은 값이 양수인지 음수인지 확인하세요.
		//조건문 사용에서 같다라는 조건만을 이용, 같다외에 >,<
		/*
		int su=10;
		if(su>0) {System.out.println("양수");}
		else if(su==0) {System.out.println("음수도 아니고 양수도 아니다.");}
		else if(su<0) {System.out.println("양수");}
		*/
		
		//입력받은 값이 양수인지 확인하고 입력받은 수까지 양수의 합을 구하세요.
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("값을 입력하세요.");
		int su=scan.nextInt();
		if(su>0) {
			//양수의 합을 구하라
			int sum=0;
			for(int i=1;i<=su;i++) {
				sum+=i;
			}
		}
		*/
		
		//입력받은 값이 양수이면 입력받은 값까지 양수의 합을 
		//음수이면 입력받은 값까지 음수의 합을 구하세요.
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("값을 입력하세요.");
		int su=scan.nextInt();
		if(su>0) {
			//양수의 합을 구하라
			int sum=0;
			for(int i=1;i<=su;i++) {
				sum+=i;
			}
		}else {
			//음수의 합 계산
			int sum=0;
			for(int i=su;i<0;i++) {
				sum+=i;
			}
		}
		*/
		
		//범위를 나누어 표현하기
		//성적이 90~100 A, 80~89 B, 70~79 C, 60~69 D, 나머지 점수는 F로 처리하세요.
		/*
		int jumsu=85;
		if(jumsu>=90) System.out.println("A");
		else if(jumsu>=80) System.out.println("B");
		else if(jumsu>=70) System.out.println("C");
		else if(jumsu>=60) System.out.println("D");
		else System.out.println("F");
		
		jumsu=75;
		if(jumsu>=90) System.out.println("A");
		if(jumsu>=80) System.out.println("B");
		if(jumsu>=70) System.out.println("C");
		if(jumsu>=60) System.out.println("D");
		
		jumsu=75;
		if(jumsu>=90 && jumsu<=100) System.out.println("A");
		if(jumsu>=80 && jumsu<90) System.out.println("B");
		if(jumsu>=70 && jumsu<80) System.out.println("C");
		if(jumsu>=60 && jumsu<70) System.out.println("D");
		else System.out.println("E");
		*/
		
		//나이를 입력받고 만약 25이면 "20대입니다"라고 표현하고 
		//나이가 60이상은 "60대 이상입니다".라고 표현하세요.
		int age=15;
		if((age/10)<2) System.out.println("10대입니다");
		else if((age/10)<3) System.out.println("20대입니다");
		else if((age/10)<4) System.out.println("30대입니다");
		else if((age/10)<5) System.out.println("40대입니다");
		else if((age/10)<6) System.out.println("40대입니다");
		else System.out.println("60대이상입니다");

		//나이가 30대가 아니면 30미만 40대 이상입니다.
		if(age!=30) System.out.println("30미만 40대 이상입니다");
		
	}

}
