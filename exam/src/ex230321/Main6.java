package ex230321;

import java.io.IOException;

public class Main6 {

	public static void main(String[] args) throws IOException {
		/*
		Main5 main=new Main5();
		main.menu();
		*/
		int sel;
		// 1)�޴������ֱ�
		//sel=menu();
		sel=menu();
		// 2)�޴�����
		//int sel=System.in.read()-48;
		//sel=sel-48;
		//System.out.println(sel);
		

	}
	
	static int menu() throws IOException {
		System.out.println("1. �л����� �Է�");
		System.out.println("2. �л����� ���");
		System.out.println("3. �л����� ����");
		System.out.println("4. �л����� ����");
		int sel=System.in.read()-48;
		return sel;
		
	}

}
