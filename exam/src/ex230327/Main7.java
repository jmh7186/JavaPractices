package ex230327;

import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		//Main6에서 구조를 가지고  가위바위보게임만들기
		// 내가 이겼다. 네가 졌다. 비겼다.
		//나의 입력, 컴퓨터 입력
		System.out.println(Math.random());
		System.out.println(Math.random()*10000);
		System.out.println((int)(Math.random()*10000));
		System.out.println((int)(Math.random()*10000)%3);
		// 0:가위, 1:바위, 2:보	
		int com=(int)(Math.random()*10000)%3;
		System.out.println("가위, 바위, 보를 입력하세요.");
		String my=(new Scanner(System.in)).nextLine();
		int mynum= my.equals("가위")? 0 : my.equals("바위")? 1 : 2;
		//System.out.println(mynum);
		/*
		//경우의 수
		가위(0) 가위(0) : 비김		
		가위(0) 바위(1) : 짐
		가위(0) 보(2)  : 이김
		
		바위(1) 가위(0) : 이김
		바위(1) 바위(1) : 비김
		바위(1) 보(2) : 짐
		
		보(2) 가위(0) : 짐
		보(2) 바위(1) : 이김
		보(2) 보(2)  : 비김
		*/
		if(mynum==com) System.out.println("비겼습니다.");
		else if((mynum==0 && com==2) ||(mynum==1 && com==0) ||(mynum==2 && com==1))
			System.out.println("당신이 이겼습니다.");
		else
			System.out.println("컴퓨터가 이겼습니다.");
		
	}

}
