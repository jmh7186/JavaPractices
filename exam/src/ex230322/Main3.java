package ex230322;

import java.io.IOException;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		Cal cal=new Cal();
		float result = 0;
		
		while(true) {
						
		System.out.println("ù��° ���� �Է��ϼ���.");
		cal.su1=scan.nextInt();
		System.out.println("�ι�° ���� �Է��ϼ���.");
		cal.su2=scan.nextInt();
		
		switch(menu()) {
		case 0:
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		case 1: result=(float)cal.add(cal.su1, cal.su2);
			break;
		case 2: result=(float)cal.minus(cal.su1, cal.su2);
			break;
		case 3: result=(float)cal.mux(cal.su1, cal.su2);
			break;
		case 4: result=(float)cal.div(cal.su1, cal.su2);
			break;
		default:
			System.out.println("�޴��� �ٽ� �����ϼ���.");
			break;
		}
		
		System.out.println("���:"+result);
		
		System.in.read();
		System.in.read();
		
		}//while end
		
		
		
		
	}
	
	static int menu() throws IOException {
		System.out.println("1.���ϱ�");
		System.out.println("2.����");
		System.out.println("3.������");
		System.out.println("4.���ϱ�");
		System.out.println("0.���α׷�����");
		return System.in.read()-48;
	}

}
