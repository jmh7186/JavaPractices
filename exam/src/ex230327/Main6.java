package ex230327;

import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		Member[] member=new Member[100];
		Scanner scan=new Scanner(System.in);
		int index=0;
		while(true) {
			System.out.println("ȸ�������� ���Ͻø� \"ȸ������\", ȸ������ ��ü����̸� \"��ü���\"�̶�� �Է��ϼ���.");
			String command=scan.nextLine();
			
			if(command.equals("ȸ������")) {
				System.out.println("ȸ�������� �Է��ϼ���.(���̵� �н����� �̸���)");
				String id=scan.next();
				String password=scan.next();
				String email=scan.next();
				scan.nextLine();
				member[index++]=new Member(id, password, email);
				System.out.println("ȸ���� ���� �Ǿ����ϴ�.");
			}else if(command.equals("��ü���") || command.equals("��ü ���")) {
				for(int i=0;i<index;i++) 
					System.out.println(member[i].toString());
			}
		}
	}

}
