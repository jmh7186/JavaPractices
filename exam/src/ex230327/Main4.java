package ex230327;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		//��. �����ʹ� �ߺ��� �ȵȴٰ� ������.
		Phonebook[] pb=new Phonebook[100];
		pb[0]=new Phonebook("ȫ�浿", "010-1111-1111");
		pb[1]=new Phonebook("�ڱ浿", "010-1111-2222");
		pb[2]=new Phonebook("�̱浿", "010-1111-3333");
		pb[3]=new Phonebook("���浿", "010-1111-4444");
		//int index=4;	
		Scanner scan=new Scanner(System.in); 
		System.out.println("ã�� �̸��� �Է��ϼ���.");
		String search=scan.nextLine();
		boolean flag=false;
		
		for(int i=0;i<pb.length;i++) { //pb.length, index�������� Ȯ��
			if(pb[i].name.equals(search)) { //pb[i].getName().equals(search)
				System.out.println("ã�� ��ȭ��ȣ��:"+pb[i].hp);
				flag=true;
				break;
			}
		}
		
		if(!flag) System.out.println("ã�� �̸��� �����ϴ�.");

	}

}
