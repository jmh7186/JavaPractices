package ex230324;

public class Main7 {

	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			System.out.print(i);
		}
		
		System.out.println();
		
		int j=6;//초기값
		
		while(j<5) {
			System.out.print(j);
			j++;//증가값
		}
		
		//한번은 꼭 실행시키고 반복하고 싶은 문장이 있을 경우
		j=6;//초기값
		do{
			System.out.print(j);
			j++;//증가값
		}while(j<5);
		
	}

}
