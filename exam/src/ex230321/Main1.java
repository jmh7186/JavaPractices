package ex230321;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Cal cal1=new Cal();
		Scanner scan=new Scanner(System.in);
		
		System.out.println("계산할 첫번째 수를 입력하세요");
		cal1.su1=scan.nextInt();
		
		System.out.println("계산할 두번째 수를 입력하세요");
		cal1.su2=scan.nextInt();
		
		System.out.println("두수의 합:"+(cal1.su1+cal1.su2));
	}
}
