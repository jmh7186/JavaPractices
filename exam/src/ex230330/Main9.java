package ex230330;
class Car1{
	public Car1() {
		System.out.println("1���� �� ź��!!!!");
	}
	public void gear() {
		System.out.println("1�� ���");
	}
}

class Car2 extends Car1{
	public Car2() {
		super.gear();
		System.out.println("2���� �� ź��!!!!");
	}
	public void gear() {
		System.out.println("2�� ���");
	}
}
class Car3 extends Car2{
	public Car3() {
		super(); //�⺻�������� �� �տ��� ���డ���ϸ� �θ�����ڸ� ȣ���ϴ� �Լ��̴�.
		super.gear(); //super�� �θ�ü�� ��Ī
		//super.super.gear(); //���θ���� �Ժη� ������ �� ����
		System.out.println("3���� �� ź��!!!!");
		
	}
	public void gear() {
		System.out.println("3�� ���");
	}
}
public class Main9 {

	public static void main(String[] args) {
		Car3 car=new Car3();
		car.gear();
	}
}
