package ex230421;

import java.util.Scanner;

class Test{
	
	//�μ��� ���ϴ� ���α׷�
	public void plus() {
		Scanner scan=new Scanner(System.in); 
		System.out.println("ù��° ���� �Է��ϼ���.");
		int a=scan.nextInt();
		System.out.println("�ι�° ���� �Է��ϼ���.");
		int b=scan.nextInt();
		System.out.println("�μ��� ��:"+(a+b));
	}
	
	public int plus(int a, int b) {
		return a+b;
	}
	
	//�Է°� ����� �����ؼ� �Լ��� ������
	//����. ���ڿ��� �Է¹޾� �����̽� ������ �и��ϴ� �Լ��� ���弼��.
	//�Լ���:split, �Է°�:���ڿ�, ��°�:���ڿ��迭
	/*
	 public ������ �Լ���(�Է°�) {
		return ��°�;
	}
	*/
	public String[] split(String s) {
		return s.split(" ");
	}
	
	//����. ���ڿ��� �Է¹ް� ���ڿ��� ���̸� ���ϴ� �Լ��� ���弼��.
	public int strlen(String s) {
		return s.length();
	}
	
	//����. ���ڿ��� �Է¹ް� �Է��� ���ڿ� 
	//��ġ�ϴ� ���ڰ� � �ִ��� �����ϴ� �Լ��� ����ÿ�.
	public int same(String s, char c) {
		int cnt=0;
		//ã�� �˰���
		//1.��� charAt�̿��� ���
		/* 
		for(int i=0;i<s.length();i++) {
			if(c==s.charAt(i)) cnt++;
		}
		*/
		
		char[] chars=s.toCharArray();
		for(int i=0;i<chars.length;i++) {
			if(c==chars[i]) cnt++;
		}
		
		return cnt;
	}
	
}
public class Main4 {

	public static void main(String[] args) {
	
		/*
		Scanner scan=new Scanner(System.in); 
		System.out.println("ù��° ���� �Է��ϼ���.");
		int a=scan.nextInt();
		System.out.println("�ι�° ���� �Է��ϼ���.");
		int b=scan.nextInt();
		System.out.println("�μ��� ��:"+(a+b));
		*/
		
		//new Test().plus();
		//System.out.println(new Test().plus(10, 20));
		
		Test t=new Test();
		for(String s:t.split("hello java !!!!")) {
			System.out.println(s);
		}
	}

}





