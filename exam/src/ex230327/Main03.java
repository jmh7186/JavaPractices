package ex230327;

public class Main03 {

	public static void main(String[] args) {
		//���º����� Ȱ���Ͽ� ã�� ���¸� Ȯ���ϴ� ���
		int[] data= {100,200,36,100,125,324};
		int search=324;
		
		int i;
		
		for(i=0;i<data.length;i++) {
			if(search==data[i]) {
				System.out.println("���� ã�ҽ��ϴ�.");
				break;//���ϰ��� �� ���
			}
		}
		
		if(i==6) {System.out.println("ã�°��� �����ϴ�.");}
		
		
		
	}

}
