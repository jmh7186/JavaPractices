package ex230327;

import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		// 0:����, 1:����, 2:��	
		int com=(int)(Math.random()*10000)%3;
		String scom= com==0 ? "����" : com==1 ? "����" : "��";
		System.out.println(scom);
		
		System.out.println("����, ����, ���� �Է��ϼ���.");
		String my=(new Scanner(System.in)).nextLine();
				
		
		if(my.equals(scom)) System.out.println("�����ϴ�.");
		else if((my.equals("����") && scom.equals("��")) 
				||(my.equals("����")&& scom.equals("����")) 
				||(my.equals("��") && scom.equals("����")))
			System.out.println("����� �̰���ϴ�.");
		else
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
		
	}

}
