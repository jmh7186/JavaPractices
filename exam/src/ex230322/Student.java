package ex230322;

public class Student {
	String id; //중복발생x, key
	String name; //중복발생
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String id,String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ",name=" + name + "]";
	}
	
	

}
