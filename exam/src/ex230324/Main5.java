package ex230324;

import java.io.IOException;

public class Main5 {

	public static void main(String[] args) throws IOException {
		//1)키보드를 눌릴 때 마다 1을 증가하는 기능을 만드세요.
		//2)1증가하는 값을 이용하여 
		int cnt=0;
		System.out.println("현재 카운터:"+cnt);
		while(true) {
		System.in.read();
		cnt=cnt+1;
		System.out.println("현재 카운터:"+cnt%10);
			while(System.in.available()!=0) System.in.read();
		}
		

	}

}
