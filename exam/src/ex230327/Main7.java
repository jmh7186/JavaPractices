package ex230327;

import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		//Main6���� ������ ������  �������������Ӹ����
		// ���� �̰��. �װ� ����. ����.
		//���� �Է�, ��ǻ�� �Է�
		System.out.println(Math.random());
		System.out.println(Math.random()*10000);
		System.out.println((int)(Math.random()*10000));
		System.out.println((int)(Math.random()*10000)%3);
		// 0:����, 1:����, 2:��	
		int com=(int)(Math.random()*10000)%3;
		System.out.println("����, ����, ���� �Է��ϼ���.");
		String my=(new Scanner(System.in)).nextLine();
		int mynum= my.equals("����")? 0 : my.equals("����")? 1 : 2;
		//System.out.println(mynum);
		/*
		//����� ��
		����(0) ����(0) : ���		
		����(0) ����(1) : ��
		����(0) ��(2)  : �̱�
		
		����(1) ����(0) : �̱�
		����(1) ����(1) : ���
		����(1) ��(2) : ��
		
		��(2) ����(0) : ��
		��(2) ����(1) : �̱�
		��(2) ��(2)  : ���
		*/
		if(mynum==com) System.out.println("�����ϴ�.");
		else if((mynum==0 && com==2) ||(mynum==1 && com==0) ||(mynum==2 && com==1))
			System.out.println("����� �̰���ϴ�.");
		else
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
		
	}

}
