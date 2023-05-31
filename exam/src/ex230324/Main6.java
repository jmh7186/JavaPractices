package ex230324;

import java.util.Scanner;

public class Main6 {
public static void main(String[] args) {
	//1~100까지 수 중 3의 배수를 출력하세요.
	for(int i=1;i<=100;i++) {
		if(i%3==0) {
			System.out.println(i);
		}
	}
	//1~100까지 수 중 3의 배수 갯수를 출력하세요.
	//(카운터알고리즘-합계알고리즘과 비슷)
	int cnt=0;
	for(int i=1; i<=100;i++) {
		if(i%3==0) {
			cnt=cnt+1;
		}
	}
	System.out.println("3의배수 갯수:"+cnt);
	
	//1~100까지의 수 중 3의 배수이고 5의 배수인 값의 갯수는?
	int i;
	cnt=0;
	for(i=1;i<=100;i++) {
		if(i%3==0 && i%5==0) {
			cnt=cnt+1;
		}
	}
	/*
	 
	 *     
	 **
	 ***
	 ****
	 ***** 
	  
	 */
	
	for(i=0;i<5;i++) {
		for(int j=0;j<=i;j++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
}
}
