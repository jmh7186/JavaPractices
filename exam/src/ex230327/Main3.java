package ex230327;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		//��. �����ʹ� �ߺ��� �ȵȴٰ� ������.
		String[] name= {"ȫ�浿","�ڱ浿","�̱浿","���浿"};
		String[] hp= {"010-1111-1111","010-1111-2222","010-1111-3333","010-1111-4444"};
		Scanner scan=new Scanner(System.in); 
		System.out.println("ã�� �̸��� �Է��ϼ���.");
		String search=scan.nextLine();
		boolean flag=false;
		
		for(int i=0;i<name.length;i++) {
			if(name[i].equals(search)) {
				System.out.println("ã�� ��ȭ��ȣ��:"+hp[i]);
				flag=true;
				break;
			}
		}
		
		if(!flag) System.out.println("ã�� �̸��� �����ϴ�.");

	}

}
