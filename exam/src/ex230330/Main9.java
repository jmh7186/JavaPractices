package ex230330;
class Car1{
	public Car1() {
		System.out.println("1세대 차 탄생!!!!");
	}
	public void gear() {
		System.out.println("1단 기어");
	}
}

class Car2 extends Car1{
	public Car2() {
		super.gear();
		System.out.println("2세대 차 탄생!!!!");
	}
	public void gear() {
		System.out.println("2단 기어");
	}
}
class Car3 extends Car2{
	public Car3() {
		super(); //기본생성자의 맨 앞에서 실행가능하며 부모생성자를 호출하는 함수이다.
		super.gear(); //super는 부모객체를 지칭
		//super.super.gear(); //조부모님은 함부로 접근할 수 없음
		System.out.println("3세대 차 탄생!!!!");
		
	}
	public void gear() {
		System.out.println("3단 기어");
	}
}
public class Main9 {

	public static void main(String[] args) {
		Car3 car=new Car3();
		car.gear();
	}
}
