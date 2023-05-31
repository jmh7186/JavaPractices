package ex230331;

public abstract class NewAnimal {
	String name;
	public NewAnimal() {
		// TODO Auto-generated constructor stub
	} 
	public NewAnimal(String name) {
	this.name=name;
	} 

	public void yourName() {
		System.out.println("My name is "+name);
	}
	
	public abstract void sound();
	public abstract void move();
}
