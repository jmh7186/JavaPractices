package ex230331;
class Bear extends Animal implements AnimalInter{
	public Bear(String name) {
		super(name);
	}
	@Override
	public void sound() {
		System.out.println("ũ�ƾ�");		
	}
	@Override
	public void move() {
		System.out.println("�ڶ׵ڶ�");
	}
}
class Rabit extends Animal implements AnimalInter{
	public Rabit(String name) {
		super(name);
	}
	@Override
	public void sound() {
		System.out.println("����");
	}
	@Override
	public void move() {
		System.out.println("���ѱ���");
	}
}
public class Main3 {

	public static void main(String[] args) {
		Bear bear=new Bear("��1");
		Rabit rabit=new Rabit("�䳢1");
		bear.yourName();
		bear.sound();
		rabit.yourName();
		rabit.sound();
		bear.move();
		rabit.move();

	}

}
