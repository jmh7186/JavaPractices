package ex230322;

public class Phonebook {
	String name;
	String hp;
	String memo;
	public Phonebook() {
		// TODO Auto-generated constructor stub
	}
	public Phonebook(String name, String hp, String memo) {
		this.name = name;
		this.hp = hp;
		this.memo = memo;
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
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "Phonebook [name=" + name + ", hp=" + hp + ", memo=" + memo + "]";
	}
	
}
