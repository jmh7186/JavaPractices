package ex230322;

import java.io.IOException;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		Cal cal=new Cal();
		int sel;
		
		while(true) {
		menu();
		sel=System.in.read()-48;
		
		System.out.println("첫번째 수를 입력하세요.");
		cal.su1=scan.nextInt();
		System.out.println("두번째 수를 입력하세요.");
		cal.su2=scan.nextInt();
		
		switch(sel) {
		case 0:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		case 1: 
			System.out.println("결과:"+cal.add(cal.su1, cal.su2));
			break;
		case 2:
			System.out.println("결과:"+cal.minus(cal.su1, cal.su2));
			break;
		case 3:
			System.out.println("결과:"+cal.mux(cal.su1, cal.su2));
			break;
		case 4:
			System.out.println("결과:"+cal.div(cal.su1, cal.su2));
			break;
		default:
			System.out.println("메뉴를 다시 선택하세요.");
			break;
		}
		
		System.in.read();
		System.in.read();
		
		}//while end
		
		
		
		
	}
	
	static void menu() {
		System.out.println("1.더하기");
		System.out.println("2.빼기");
		System.out.println("3.나누기");
		System.out.println("4.곱하기");
		System.out.println("0.프로그램종료");
	}

}
