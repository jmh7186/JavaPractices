package ex230322_1;
//�л��� ������ ������.
public class Student {
	private String id;
	private String name;
	Score score;
	//�⺻������(ctrl+space), �ʵ������, get, set, toString(source-���� ��� ����)
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String id, String name, Score score) {
		
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	
}
