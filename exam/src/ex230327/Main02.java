package ex230327;

public class Main02 {

	public static void main(String[] args) {
		//���º����� Ȱ���Ͽ� ã�� ���¸� Ȯ���ϴ� ���
		int[] data= {100,200,36,100,125,324};
		int search=10;
		//���º��������
		boolean flag=false;
		
		for(int i=0;i<data.length;i++) {
			if(search==data[i]) {
				System.out.println("���� ã�ҽ��ϴ�.");
				flag=true;
			}
		}
		
		if(!flag) System.out.println("ã�� ���� �����ϴ�.");
		
	}

}
