package ex230324;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		switch(str) {
		case "hello": System.out.println("�ȳ��ϼ���."); break;
		case "go": System.out.println("����"); break;
		case "run": System.out.println("�پ��"); break;
		default: System.out.println("���� �ܾ��Դϴ�."); break;
		}

	}

}
