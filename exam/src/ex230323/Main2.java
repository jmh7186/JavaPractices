package ex230323;

public class Main2 {

	public static void main(String[] args) {
		//1���� 10���� ���
		int i;
		for(i=1;i<=10;i++) {
			System.out.print(i);
		}
		
		System.out.println();
				
		i=1;
		while(i<=10) {
			System.out.print(i);
			i++;
		}
		
		System.out.println();
		
		i=1;
		while(true) {
			if(i==10) {break;}
			System.out.print("����:"+i);
			//if(i==10) {break;}
			i++;
		}
		
		System.out.println();
		System.out.println("�Ϸ�:"+i);
		

	}

}
