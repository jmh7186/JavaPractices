package ex230321;

import java.io.IOException;

public class Main5 {

	public static void main(String[] args) throws IOException {
		/*
		Main5 main=new Main5();
		main.menu();
		*/
		while(true) {
		// 1)�޴������ֱ�
		menu();
		// 2)�޴�����
		int sel=System.in.read()-48;
		//sel=sel-48;
		//System.out.println(sel);
		// 3)� �޴��� ���õǾ��°��� Ȯ�� �� ó��
		if(sel==1) {
			System.out.println("�л������� �ԷµǾ����ϴ�.");
		}else if(sel==2) {
			System.out.println("�л������� ��µǾ����ϴ�.");
		}else if(sel==3) {
			System.out.println("�л������� �����Ǿ����ϴ�.");
		}else if(sel==4) {
			System.out.println("�л������� �����Ǿ����ϴ�.");
		}else {
			System.out.println("�޴��� �ٽ� �����ϼ���.");
		}
		
		while(System.in.available()!=0) {
			System.in.read();
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
