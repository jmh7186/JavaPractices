package ex230324;

import java.io.IOException;

public class Main5 {

	public static void main(String[] args) throws IOException {
		//1)Ű���带 ���� �� ���� 1�� �����ϴ� ����� ���弼��.
		//2)1�����ϴ� ���� �̿��Ͽ� 
		int cnt=0;
		System.out.println("���� ī����:"+cnt);
		while(true) {
		System.in.read();
		cnt=cnt+1;
		System.out.println("���� ī����:"+cnt%10);
			while(System.in.available()!=0) System.in.read();
		}
		

	}

}
