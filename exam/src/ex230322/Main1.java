package ex230322;

import java.io.IOException;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) throws IOException {
		//����(�޴�-�޴�����-������)->�ݺ�
		
		//�޴�
		System.out.println("1.���ϱ�");
		System.out.println("2.����");
		System.out.println("3.������");
		System.out.println("4.���ϱ�");
		//�޴�����
		int sel=System.in.read()-48;
		//������� 
		//1)print�̿� 
		//2) ����� �� ��ġ�� ����Ŭ���Ͽ� �극��ŷ ������ ����-f11(debug)-f6-������ Ȯ��
		//System.out.println(sel);
		
		//����� ����ϱ��� �ʿ��� ������ �ִ��� Ȯ��
		System.out.println("ù��° ���� �Է��ϼ���.");
		Scanner scan=new Scanner(System.in);
		int su1=scan.nextInt();
		System.out.println("�ι�° ���� �Է��ϼ���.");
		int su2=scan.nextInt();
		System.out.println("���:"+(su1+su2));
		
	}

}
