package ex230324;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		//Ȧ�� ¦���� �Ǻ��ϼ���.
		//�����м�. ���(������, �Է°�)�� ���� Ȧ�� ���� ¦������ �Ǻ��ϴ°�?
		//�Է�-ó�� �� �м�-����� Ȱ���Ͽ� �� �ٸ� ������� ǥ��
		/*
		int su=10;
		if(su%2==1) {
			System.out.println("Ȧ���Դϴ�.");
		}else {
			System.out.println("¦���Դϴ�.");
		}
		*/
		
		//�߰�����)���ڸ� �Է¹޾� Ȧ������ ¦������ �Ǻ��ϼ���.
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("Ȧ�� ¦���� �Ǻ��ϱ� ���� ���ڸ� �Է��ϼ���.");
		int su=scan.nextInt();
		if(su%2==1) {
			System.out.println("Ȧ���Դϴ�.");
		}else {
			System.out.println("¦���Դϴ�.");
		}
		*/
		//�߰�����)1���� 10���� Ȧ���� ���� ���ϼ���.(�����˾ƾ��� ����:1����10���� �ձ��ϱ�)
		/*
		int sum=0;
		for(int i=1;i<11;i++) {
			if(i%2==1)	sum=sum+i;
		}
		System.out.println(sum);
		*/
		//�߰�����)1���� 10���� Ȧ���� ¦���� ���� ���ϼ���.
		/*
		int odd=0;
		int eve=0;
		for(int i=1;i<11;i++) {
			if(i%2==1) odd=odd+i;
			else eve=eve+i;
		}
		System.out.println("Ȧ���� ��:"+odd);
		System.out.println("¦���� ��:"+eve);
		*/
		//�Է¹��� ���� 100�� ��� 1���� 100������ ���ϰ�
		//�Է¹��� ���� 50�̸� 1���� 50������ ���� ���ϼ���.
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���.");
		int su=scan.nextInt();
		int sum=0;
		for(int i=1;i<=su;i++) {
			sum=sum+i;
		}
		System.out.println(sum);
		*/
		//�� ���� �Է¹ް� �Է¹��� ������ ���� ���ϼ���.
		//10 20:�Է� -> 10���� 20������ ���� ���ϼ���.
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("�Է� ������ �Է��ϼ���.��)10 20");
		int su1=scan.nextInt();
		int su2=scan.nextInt();
		int sum=0;
		for(int i=su1;i<=su2;i++) {
			sum=sum+i;
		}
		System.out.println(sum);
		*/
		//���� �ڵ忡 ������ ����. ���������� �ֳ���? 20 10
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("�Է� ������ �Է��ϼ���.��)10 20");
		int su1=scan.nextInt();
		int su2=scan.nextInt();
		if(su1>su2) {
			//su1�� su2�� ��ȯ
			int imsi=su1;
			su1=su2;
			su2=imsi;
		}
		int sum=0;
		for(int i=su1;i<=su2;i++) {
			sum=sum+i;
		}
		System.out.println(sum);
		*/
			
		//�Է¹��� ���� ������� �������� Ȯ���ϼ���.
		//���ǹ� ��뿡�� ���ٶ�� ���Ǹ��� �̿�, ���ٿܿ� >,<
		/*
		int su=10;
		if(su>0) {System.out.println("���");}
		else if(su==0) {System.out.println("������ �ƴϰ� ����� �ƴϴ�.");}
		else if(su<0) {System.out.println("���");}
		*/
		
		//�Է¹��� ���� ������� Ȯ���ϰ� �Է¹��� ������ ����� ���� ���ϼ���.
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("���� �Է��ϼ���.");
		int su=scan.nextInt();
		if(su>0) {
			//����� ���� ���϶�
			int sum=0;
			for(int i=1;i<=su;i++) {
				sum+=i;
			}
		}
		*/
		
		//�Է¹��� ���� ����̸� �Է¹��� ������ ����� ���� 
		//�����̸� �Է¹��� ������ ������ ���� ���ϼ���.
		/*
		Scanner scan=new Scanner(System.in);
		System.out.println("���� �Է��ϼ���.");
		int su=scan.nextInt();
		if(su>0) {
			//����� ���� ���϶�
			int sum=0;
			for(int i=1;i<=su;i++) {
				sum+=i;
			}
		}else {
			//������ �� ���
			int sum=0;
			for(int i=su;i<0;i++) {
				sum+=i;
			}
		}
		*/
		
		//������ ������ ǥ���ϱ�
		//������ 90~100 A, 80~89 B, 70~79 C, 60~69 D, ������ ������ F�� ó���ϼ���.
		/*
		int jumsu=85;
		if(jumsu>=90) System.out.println("A");
		else if(jumsu>=80) System.out.println("B");
		else if(jumsu>=70) System.out.println("C");
		else if(jumsu>=60) System.out.println("D");
		else System.out.println("F");
		
		jumsu=75;
		if(jumsu>=90) System.out.println("A");
		if(jumsu>=80) System.out.println("B");
		if(jumsu>=70) System.out.println("C");
		if(jumsu>=60) System.out.println("D");
		
		jumsu=75;
		if(jumsu>=90 && jumsu<=100) System.out.println("A");
		if(jumsu>=80 && jumsu<90) System.out.println("B");
		if(jumsu>=70 && jumsu<80) System.out.println("C");
		if(jumsu>=60 && jumsu<70) System.out.println("D");
		else System.out.println("E");
		*/
		
		//���̸� �Է¹ް� ���� 25�̸� "20���Դϴ�"��� ǥ���ϰ� 
		//���̰� 60�̻��� "60�� �̻��Դϴ�".��� ǥ���ϼ���.
		int age=15;
		if((age/10)<2) System.out.println("10���Դϴ�");
		else if((age/10)<3) System.out.println("20���Դϴ�");
		else if((age/10)<4) System.out.println("30���Դϴ�");
		else if((age/10)<5) System.out.println("40���Դϴ�");
		else if((age/10)<6) System.out.println("40���Դϴ�");
		else System.out.println("60���̻��Դϴ�");

		//���̰� 30�밡 �ƴϸ� 30�̸� 40�� �̻��Դϴ�.
		if(age!=30) System.out.println("30�̸� 40�� �̻��Դϴ�");
		
	}

}
