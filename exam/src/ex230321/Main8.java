package ex230321;

import java.io.IOException;
import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) throws IOException {
		Student s1=new Student();
		Scanner scan=new Scanner(System.in);
		
		while(true) {
		menu();
		int sel=System.in.read()-48;
		
		while(System.in.available()!=0) {
			System.in.read();
		}
		
		if(sel==1) {
			System.out.print("�й��� �Է��ϼ���.");
			String id=scan.nextLine();
			System.out.print("�̸��� �Է��ϼ���.");
			String name=scan.nextLine();
			s1.setInfo(id, name);			
			System.out.println("�л������� �ԷµǾ����ϴ�.");
		}else if(sel==2) {
			s1.info();
			System.out.println("�л������� ��µǾ����ϴ�.");
		}else if(sel==3) {
			System.out.println("�л������� �����Ǿ����ϴ�.");
		}else if(sel==4) {
			System.out.println("�л������� �����Ǿ����ϴ�.");
		}else {
			System.out.println("�޴��� �ٽ� �����ϼ���.");
		}
		
		
		
		System.in.read();
		System.in.read();		
		
		}
		
	}
	
	static void menu() {
		System.out.println("1. �л����� �Է�");
		System.out.println("2. �л����� ���");
		System.out.println("3. �л����� ����");
		System.out.println("4. �л����� ����");
	}

}
