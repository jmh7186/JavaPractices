package ex230328;

public class Phonebook {
	String name;
	String hp;
	public Phonebook() {
		// TODO Auto-generated constructor stub
	}
	public Phonebook(String name, String hp) {
		
		this.name = name;
		this.hp = hp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	@Override
	public String toString() {
		return "Phonebook [name=" + name + ", hp=" + hp + "]";
	}
	
	
	
}
