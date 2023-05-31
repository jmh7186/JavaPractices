package ex230322;

import java.io.IOException;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) throws IOException {
		//설계(메뉴-메뉴선택-결과출력)->반복
		
		//메뉴
		System.out.println("1.더하기");
		System.out.println("2.빼기");
		System.out.println("3.나누기");
		System.out.println("4.곱하기");
		//메뉴선택
		int sel=System.in.read()-48;
		//디버깅방법 
		//1)print이용 
		//2) 결과를 볼 위치에 더블클릭하여 브레이킹 포인터 설정-f11(debug)-f6-변수값 확인
		//System.out.println(sel);
		
		//결과를 출력하기전 필요한 사항이 있는지 확인
		System.out.println("첫번째 수를 입력하세요.");
		Scanner scan=new Scanner(System.in);
		int su1=scan.nextInt();
		System.out.println("두번째 수를 입력하세요.");
		int su2=scan.nextInt();
		System.out.println("결과:"+(su1+su2));
		
	}

}
