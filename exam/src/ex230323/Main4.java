package ex230323;

public class Main4 {

	public static void main(String[] args) {
		//1���� 10���� �ݺ��߿� ¦���� ���� ����Ͻÿ�.
		//1���� 10���� �ݺ��߿� ¦���� ���� ����Ͻÿ�.
		
		for(int i=0;i<11;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
		//1�� 10�����ϱ�
		 int sum=0;
		for(int i=1;i<=10;i++) {
			sum=sum+1;
		}
		System.out.println("���:"+sum);
		
		//1���� 10������ ���� ���ϼ���.
		sum=0;
		for(int i=1;i<=10;i++) {
			sum=sum+i;
		}
		System.out.println("���:"+sum);
		
		//150���� 200������ ���� ���ϼ���.
		sum=0;
		for(int i=150;i<=200;i++) {
			sum=sum+i;
		}
		System.out.println("���:"+sum);
		
		sum=0;
		for(int i=0;i<=50;i++) {
			sum=sum+150+i;
		}
		System.out.println("���:"+sum);
		
		//������ 2���� ����ϼ���.
		for(int i=1;i<=9;i++) {
		System.out.println("2*" + i + "=" + (2*i));
		}
		
		for(int i=1;i<=9;i++) {
			sum=2*i;
			System.out.printf("2*%d=%d",i, sum);
		}
	}

}
