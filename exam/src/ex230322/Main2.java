package ex230322;

import java.io.IOException;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		Cal cal=new Cal();
		int sel;
		
		while(true) {
		menu();
		sel=System.in.read()-48;
		
		System.out.println("ù��° ���� �Է��ϼ���.");
		cal.su1=scan.nextInt();
		System.out.println("�ι�° ���� �Է��ϼ���.");
		cal.su2=scan.nextInt();
		
		switch(sel) {
		case 0:
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		case 1: 
			System.out.println("���:"+cal.add(cal.su1, cal.su2));
			break;
		case 2:
			System.out.println("���:"+cal.minus(cal.su1, cal.su2));
			break;
		case 3:
			System.out.println("���:"+cal.mux(cal.su1, cal.su2));
			break;
		case 4:
			System.out.println("���:"+cal.div(cal.su1, cal.su2));
			break;
		default:
			System.out.println("�޴��� �ٽ� �����ϼ���.");
			break;
		}
		
		System.in.read();
		System.in.read();
		
		}//while end
		
		
		
		
	}
	
	static void menu() {
		System.out.println("1.���ϱ�");
		System.out.println("2.����");
		System.out.println("3.������");
		System.out.println("4.���ϱ�");
		System.out.println("0.���α׷�����");
	}

}
