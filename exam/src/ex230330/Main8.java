package ex230330;
class Car{
    public void gear(){
        System.out.println("���� �� ����մϴ�.");
    }
}
class ChildCar extends Car{
    public void autogear(){
        System.out.println("�ڵ� �� ����մϴ�.");
    }
}
class HybridCar extends ChildCar{
	public void hybridgear() {
		gear();
		autogear();
	}
}
public class Main8 {

	public static void main(String[] args) {
		ChildCar car=new ChildCar();
		car.autogear();
		car.gear();
		// new ChildCar().autogear();
		

	}

}
