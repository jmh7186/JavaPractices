package ex230327;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		//��. �����ʹ� �ߺ��� �ȵȴٰ� ������.
		String[] data= {"ȫ�浿","�ڱ浿","�̱浿","���浿"};
		Scanner scan=new Scanner(System.in); 
		System.out.println("ã�� �̸��� �Է��ϼ���.");
		String search=scan.nextLine();
		boolean flag=false;
		
		for(int i=0;i<data.length;i++) {
			if(data[i].equals(search)) {
				System.out.println("ã�� �̸��� �ֽ��ϴ�");
				flag=true;
				break;
			}
		}
		
		if(!flag) System.out.println("ã�� �̸��� �����ϴ�.");

	}

}
