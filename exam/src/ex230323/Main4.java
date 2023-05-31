package ex230323;

public class Main4 {

	public static void main(String[] args) {
		//1에서 10까지 반복중에 짝수의 값만 출력하시오.
		//1에서 10까지 반복중에 짝수일 때만 출력하시오.
		
		for(int i=0;i<11;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
		//1을 10번더하기
		 int sum=0;
		for(int i=1;i<=10;i++) {
			sum=sum+1;
		}
		System.out.println("결과:"+sum);
		
		//1에서 10까지의 합을 구하세요.
		sum=0;
		for(int i=1;i<=10;i++) {
			sum=sum+i;
		}
		System.out.println("결과:"+sum);
		
		//150에서 200까지의 합을 구하세요.
		sum=0;
		for(int i=150;i<=200;i++) {
			sum=sum+i;
		}
		System.out.println("결과:"+sum);
		
		sum=0;
		for(int i=0;i<=50;i++) {
			sum=sum+150+i;
		}
		System.out.println("결과:"+sum);
		
		//구구단 2단을 출력하세요.
		for(int i=1;i<=9;i++) {
		System.out.println("2*" + i + "=" + (2*i));
		}
		
		for(int i=1;i<=9;i++) {
			sum=2*i;
			System.out.printf("2*%d=%d",i, sum);
		}
	}

}
