package ex230327;

import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		// 0:가위, 1:바위, 2:보	
		int com=(int)(Math.random()*10000)%3;
		String scom= com==0 ? "가위" : com==1 ? "바위" : "보";
		System.out.println(scom);
		
		System.out.println("가위, 바위, 보를 입력하세요.");
		String my=(new Scanner(System.in)).nextLine();
				
		
		if(my.equals(scom)) System.out.println("비겼습니다.");
		else if((my.equals("가위") && scom.equals("보")) 
				||(my.equals("바위")&& scom.equals("가위")) 
				||(my.equals("보") && scom.equals("바위")))
			System.out.println("당신이 이겼습니다.");
		else
			System.out.println("컴퓨터가 이겼습니다.");
		
	}

}
