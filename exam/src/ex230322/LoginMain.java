package ex230322;

import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		
		/*
		Login login1=new Login();
		//login1.id="admin";
		login1.setId("admin");
		System.out.println(login1.getId());
		System.out.println(login1.toString());
		login1.setPassword("1234");
		System.out.println(login1.toString());
		
		if(login1.loginAccess("admin","1234")) {
			System.out.println("�α��� ����");
		}else {
			System.out.println("�α��� ����");
		}
		*/
		
		/*
		Login login2=new Login("user", "0000");
		System.out.println(login2.toString());
		*/
		
		/* ȸ������ */
		Scanner scan=new Scanner(System.in);
		System.out.println("ȸ������");
		System.out.println("���̵� �Է��ϼ���.");
		String id=scan.nextLine();
		System.out.println("�н����带 �Է��ϼ���.");
		String password=scan.nextLine();
		
		Login login3=new Login(id, password);
		System.out.println("ȸ�������� �Ǽ̽��ϴ�.");
		System.out.println(login3.toString());
		//�ʿ��� ����?�Ӽ����� ����ִ� ����, ����, ���ϴ� ������ �ԷµǾ��°�
		
	}

}
