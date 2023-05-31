package ex230322;

import java.io.IOException;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		Cal cal=new Cal();
		float result = 0;
		
		while(true) {
						
		System.out.println("첫번째 수를 입력하세요.");
		cal.su1=scan.nextInt();
		System.out.println("두번째 수를 입력하세요.");
		cal.su2=scan.nextInt();
		
		switch(menu()) {
		case 0:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		case 1: result=(float)cal.add(cal.su1, cal.su2);
			break;
		case 2: result=(float)cal.minus(cal.su1, cal.su2);
			break;
		case 3: result=(float)cal.mux(cal.su1, cal.su2);
			break;
		case 4: result=(float)cal.div(cal.su1, cal.su2);
			break;
		default:
			System.out.println("메뉴를 다시 선택하세요.");
			break;
		}
		
		System.out.println("결과:"+result);
		
		System.in.read();
		System.in.read();
		
		}//while end
		
		
		
		
	}
	
	static int menu() throws IOException {
		System.out.println("1.더하기");
		System.out.println("2.빼기");
		System.out.println("3.나누기");
		System.out.println("4.곱하기");
		System.out.println("0.프로그램종료");
		return System.in.read()-48;
	}

}
