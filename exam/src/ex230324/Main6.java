package ex230324;

import java.util.Scanner;

public class Main6 {
public static void main(String[] args) {
	//1~100���� �� �� 3�� ����� ����ϼ���.
	for(int i=1;i<=100;i++) {
		if(i%3==0) {
			System.out.println(i);
		}
	}
	//1~100���� �� �� 3�� ��� ������ ����ϼ���.
	//(ī���;˰���-�հ�˰���� ���)
	int cnt=0;
	for(int i=1; i<=100;i++) {
		if(i%3==0) {
			cnt=cnt+1;
		}
	}
	System.out.println("3�ǹ�� ����:"+cnt);
	
	//1~100������ �� �� 3�� ����̰� 5�� ����� ���� ������?
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
