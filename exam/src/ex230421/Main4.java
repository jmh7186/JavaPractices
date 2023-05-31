package ex230421;

import java.util.Scanner;

class Test{
	
	//두수를 더하는 프로그램
	public void plus() {
		Scanner scan=new Scanner(System.in); 
		System.out.println("첫번째 값을 입력하세요.");
		int a=scan.nextInt();
		System.out.println("두번째 값을 입력하세요.");
		int b=scan.nextInt();
		System.out.println("두수의 합:"+(a+b));
	}
	
	public int plus(int a, int b) {
		return a+b;
	}
	
	//입력과 출력을 생각해서 함수를 만들어라
	//문제. 문자열을 입력받아 스페이스 단위로 분리하는 함수를 만드세요.
	//함수명:split, 입력값:문자열, 출력값:문자열배열
	/*
	 public 리턴형 함수명(입력값) {
		return 출력값;
	}
	*/
	public String[] split(String s) {
		return s.split(" ");
	}
	
	//문제. 문자열을 입력받고 문자열의 길이를 구하는 함수를 만드세요.
	public int strlen(String s) {
		return s.length();
	}
	
	//문제. 문자열을 입력받고 입력한 문자와 
	//일치하는 문자가 몇개 있는지 리턴하는 함수를 만드시오.
	public int same(String s, char c) {
		int cnt=0;
		//찾기 알고리즘
		//1.방법 charAt이용한 방법
		/* 
		for(int i=0;i<s.length();i++) {
			if(c==s.charAt(i)) cnt++;
		}
		*/
		
		char[] chars=s.toCharArray();
		for(int i=0;i<chars.length;i++) {
			if(c==chars[i]) cnt++;
		}
		
		return cnt;
	}
	
}
public class Main4 {

	public static void main(String[] args) {
	
		/*
		Scanner scan=new Scanner(System.in); 
		System.out.println("첫번째 값을 입력하세요.");
		int a=scan.nextInt();
		System.out.println("두번째 값을 입력하세요.");
		int b=scan.nextInt();
		System.out.println("두수의 합:"+(a+b));
		*/
		
		//new Test().plus();
		//System.out.println(new Test().plus(10, 20));
		
		Test t=new Test();
		for(String s:t.split("hello java !!!!")) {
			System.out.println(s);
		}
	}

}





