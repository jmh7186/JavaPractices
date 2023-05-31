package ex230327;

import java.io.IOException;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) throws IOException {
		Phonebook[] pb=new Phonebook[100];
		Scanner scan=new Scanner(System.in);
		int index=0;
		String name;
		String hp;
		String search;
		boolean flag;
		
		while(true) {
			
			
			switch(menu()) {
				
				case 1: //�����Է�
					System.out.println("�̸��� ��ȭ��ȣ�� �Է��ϼ���.(�� ȫ�浿 011-1111-1111");
					name=scan.next();
					hp=scan.next();
					pb[index]=new Phonebook(name, hp);
					index=index+1;
					System.out.println("��ȭ��ȣ�ο� �Է��� �Ǿ����ϴ�.");
					System.out.println("(�������� �ѱ���� ����Ű�� ���ּ���.)");
					break;
				case 2:
					System.out.println("---------------");
					System.out.println("  �̸�  ��ȭ��ȣ");
					System.out.println("---------------");
					for(int i=0;i<index;i++) {
						if(!(pb[i].name.equals("")))
						System.out.printf("%s %s\n",pb[i].name, pb[i].hp);
					}
					System.out.println("---------------"); 
					System.out.println("(�������� �ѱ���� ����Ű�� ���ּ���.)");
					break;
				case 3: // ã�Ⱚ�Է�-��ü�����͸� ã�°��� �񱳸� �ϴ°�
					System.out.println("ã�� �̸��� �Է��ϼ���.");
					search=scan.nextLine();
					flag=false;
					//pb.length����� ��� null�� ������ �����߻�
					for(int i=0;i<index;i++) { 
						if(pb[i].name.equals(search)) { 
							System.out.println("ã�� ��ȭ��ȣ��:"+pb[i].hp);
							flag=true;
							break;
						}
						
					}
					
					if(!flag) System.out.println("ã�� �̸��� �����ϴ�.");
					break;
				case 4: //����->ã��->index�� �̿��Ͽ� ���� pb[index].hp����
					System.out.println("������ �̸��� �Է��ϼ���.");
					search=scan.nextLine();
					flag=false;
					
					for(int i=0;i<index;i++) { 
						if(pb[i].name.equals(search)) { 
							//��������� �Է¹޾� ó��
							System.out.println("������ ��ȭ��ȣ�� �Է��ϼ���.");
							hp=scan.nextLine();
							pb[i].hp=hp; //pb[i].setHp(hp);
							flag=true;
							System.out.println("������ �����Ǿ����ϴ�.");
							break;
						}
					}
					if(!flag) System.out.println("������ �̸��� �����ϴ�.");
					break;
					
				case 5://����->ã��->index�� �̿��Ͽ� ����
					   //1)pb[i]=null; 2)pb[i].name="", pb[i].hp=""
					System.out.println("������ �̸��� �Է��ϼ���.");
					search=scan.nextLine();
					flag=false;
					
					for(int i=0;i<index;i++) { 
						if(pb[i].name.equals(search)) { 
							//pb[i]=null;
							pb[i].hp="";
							pb[i].name="";
							flag=true;
							System.out.println("������ �����Ǿ����ϴ�.");
							break;
						}
					}
					if(!flag) System.out.println("������ �̸��� �����ϴ�.");
					break;
			}
			
			System.in.read();
			while(System.in.available()>0) {
				System.in.read();
			}
		
		}

	}

	static int menu() throws IOException {
		//��ü���� �������� ó���ϱ����ؼ��� [ã��]
		System.out.println("-------------------");
		System.out.println("1.��ȭ��ȣ�� �Է�"); //�����Է�
		System.out.println("2.��ȭ��ȣ�� ��ü ���"); //��ü���, �������
		System.out.println("3.��ȭ��ȣ�� ���� ���");
		System.out.println("4.��ȭ��ȣ�� ����"); //��������
		System.out.println("5.��ȭ��ȣ�� ����"); //��������
		System.out.println("-------------------");
		int sel=System.in.read()-48;
		while(System.in.available()>0) {
			System.in.read();
		}
		return sel;
	
	}
}
