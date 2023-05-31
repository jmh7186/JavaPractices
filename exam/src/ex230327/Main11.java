package ex230327;

class Car{
	String name;
	int cc;
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String name, int cc) {
		this.name=name;
		this.cc=cc;
	}
	public Car(String name) {
		this.name=name;
	}
	public Car(int cc) {
		this.cc=cc;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "hello";
	}
	
}

public class Main11 {

	public static void main(String[] args) {
		Car car1=new Car();
		car1.name="sonata";
		car1.cc=2000;
		
		System.out.println("Â÷·®¸í:"+car1.name);
		System.out.println("cc :"+car1.cc);
		System.out.println(car1.toString());

	}

}
