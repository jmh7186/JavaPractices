package ex230324;

import java.util.Scanner;

public class Main10 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		/*
		System.out.println(scan.nextInt());
		System.out.println(scan.hasNext());
		System.out.println(scan.nextInt());
		System.out.println(scan.hasNext());
		System.out.println(scan.hasNext());
		*/
		
		int a[]=new int[10];
		for(int i=0;scan.hasNext();i++) {
			a[i]=scan.nextInt();
		}
		
		int sum=0;
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
			sum=sum+a[i];
		}
		
		//배열초기화 방법
	}

}
