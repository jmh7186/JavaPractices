package ex230324;

public class Main7 {

	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			System.out.print(i);
		}
		
		System.out.println();
		
		int j=6;//�ʱⰪ
		
		while(j<5) {
			System.out.print(j);
			j++;//������
		}
		
		//�ѹ��� �� �����Ű�� �ݺ��ϰ� ���� ������ ���� ���
		j=6;//�ʱⰪ
		do{
			System.out.print(j);
			j++;//������
		}while(j<5);
		
	}

}
