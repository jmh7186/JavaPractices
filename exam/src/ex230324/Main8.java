package ex230324;

public class Main8 {

	public static void main(String[] args) {
		int i=1;
		while(i<20) {
			System.out.print(i++);
			if(i==10) break; //break는 반복문을 빠져나오는 구문
		}

		System.out.println("프로그램 end");
	}

}
