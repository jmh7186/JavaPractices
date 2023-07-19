package springbasic;

public class Test {
	int id;
	String name;
	float f;
	
	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public Test(int id, String name, float f) {
		super();
		this.id = id;
		this.name = name;
		this.f = f;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setF(float f) {
		this.f = f;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", f=" + f + "]";
	}
	
}
