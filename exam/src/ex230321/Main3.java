package ex230321;

public class Main3 {

	public static void main(String[] args) {
		Cal cal=new Cal();
		
		//직접값을 입력하여 계산
		int result=cal.add(100, 200);
		System.out.println("결과값:"+result);
		
		//변수에 값을 입력하여 계산
		int a=300;
		int b=400;
		result=cal.add(a, b);
		System.out.println("결과값:"+result);
		
		//함수를 통한 값 입력
		result=cal.add(cal.add(100, 200), cal.add(300, 400));
		cal.add(10, cal.add(300, 400));
		cal.add(cal.add(100, 200), a);
		cal.add(b, cal.add(300, 400));

	}

}
