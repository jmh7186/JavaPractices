package ex230324;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		switch(str) {
		case "hello": System.out.println("안녕하세요."); break;
		case "go": System.out.println("간다"); break;
		case "run": System.out.println("뛰어라"); break;
		default: System.out.println("없는 단어입니다."); break;
		}

	}

}
