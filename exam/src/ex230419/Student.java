package ex230419;

import java.io.Serializable;

public class Student implements Serializable{
	String id;
	String name;
	int kor;
	int eng;
	int math;
	public Student(String id, String name, int kor, int eng, int math) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
}
