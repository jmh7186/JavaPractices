package ex230331;
class Bear extends Animal implements AnimalInter{
	public Bear(String name) {
		super(name);
	}
	@Override
	public void sound() {
		System.out.println("Å©¾Æ¾Ó");		
	}
	@Override
	public void move() {
		System.out.println("µÚ¶×µÚ¶×");
	}
}
class Rabit extends Animal implements AnimalInter{
	public Rabit(String name) {
		super(name);
	}
	@Override
	public void sound() {
		System.out.println("³©³©");
	}
	@Override
	public void move() {
		System.out.println("±øÃÑ±øÃÑ");
	}
}
public class Main3 {

	public static void main(String[] args) {
		Bear bear=new Bear("°õ1");
		Rabit rabit=new Rabit("Åä³¢1");
		bear.yourName();
		bear.sound();
		rabit.yourName();
		rabit.sound();
		bear.move();
		rabit.move();

	}

}
