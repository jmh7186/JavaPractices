package ex230331;

 //자동차의 속성은 자동차명, CC, 년식이 있고 기능은 설계한 기능을 넣으려고 합니다.
//Car클래스를 만드세요. 
//각 기능은 System.out.println을 사용하여 문자열로 핸드조작일 경우 "핸들조작"이라는 문장이 출력되게 합니다. 다른 기능 또한 이와 같이 구현하면 됩니다.
//
//자동차 객체를 만들고 속성값을 다음과 같이 입력하는 생성자를 만듭니다.
public class Car implements CarInter{
	String name;
	int cc;
	int year;
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Car(String name, int cc, int year) {
		this.name = name;
		this.cc = cc;
		this.year = year;
	}


	@Override
	public void movehandle() {
		System.out.println("핸들조작");
		
	}
	@Override
	public void controllerAcc() {
		System.out.println("엑셀레이터조작");
		
	}
	@Override
	public void controllerBreak() {
		System.out.println("브레이크조작");
		
	}
	@Override
	public void controllerWindow() {
		System.out.println("창문조작");	
	}
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", cc=" + cc + ", year=" + year + "]";
	}
	
	
	
}

