package ex230327;

public class Main04 {

	public static void main(String[] args) {
		//���º����� Ȱ���Ͽ� ã�� ���¸� Ȯ���ϴ� ���
		int[] data= {100,200,36,100,125,324};
		int search=100;
		//���º��������
		boolean flag=false;
		//��� �˻��Ǿ����� Ȯ��(ī���� �˰���)
		int cnt=0;
		
		for(int i=0;i<data.length;i++) {
			if(search==data[i]) {
				System.out.println(data[i]);
				cnt=cnt+1;
				flag=true;
			}
		}
		
		if(!flag) System.out.println("ã�� ���� �����ϴ�.");
		System.out.println("ã������:"+cnt);
		
	}

}
