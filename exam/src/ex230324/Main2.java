package ex230324;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		/* 
		 *****
		 *****
		 *****
		 *****
		*/
		for(int i=1;i<21;i++) {
		System.out.print("*");
		//5��° ���� ���� �� �ٹٲ��� ����
		if(i%5==0) {System.out.println();}
		}
		
		/* 
		 12345
		 678910
		 1112131415
		 1617181920
		*/
		for(int i=1;i<21;i++) {
			System.out.print(i);
			if(i%5==0) {System.out.println();}
		}
		
		/* 
		 01234
		 56789
		 1011121314
		 1516171819
		*/

		for(int i=0;i<20;i++) {
			System.out.print(i);
			if(i==0) {continue; }
			if(i%5==0) {System.out.println();}	
		}
		
		System.out.println();
		
		for(int i=0;i<20;i++) {
			if(i!=0) {if(i%5==0) {System.out.println();}}
			System.out.print(i);
		}
		System.out.println();
		
		/* 
		 *****
		 *****
		 *****
		 *****
		*/
		
		for(int j=0;j<4;j++) {
			for(int i=0;i<5;i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 2�ܿ��� 9�ܱ��� ����ϼ���.
		for(int dan=2;dan<10;dan++) {
		for(int i=1;i<10;i++) {
			System.out.printf("%d*%d=%d",dan,i,dan*i);
		}
		System.out.println();
		}
		
		
		//���빮��) ������ �Է¹ް� ���� ������ 79���̸� *�� 7�� ���, 
		//90���̸� 9���� ��µǴ� ���α׷��� ����ÿ�.
		//hint)Scanner, ����, ������� �ݺ�Ȱ��
		Scanner scan=new Scanner(System.in);
		System.out.println("������ �Է��ϼ���.");
		int jumsu=scan.nextInt();
		
		int cnt=jumsu/10;
		
		for(int i=0;i<cnt;i++) {
			System.out.print("*");
		}
		
		//�������� ���� �Է¹޾� �Է¹��� �ܿ� ���� ����ϼ���.
		System.out.println("���� �Է��ϼ���.");
		int dan=scan.nextInt();
		
		for(int i=1;i<10;i++) {
			System.out.printf("%d*%d=%d\n",dan,i,dan*i);
		}
				
	}

}
