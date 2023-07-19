package annotation3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="s")
public class Student {
	String id;
	String name;
	@Autowired(required = false)
	Score score;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String id, String name, Score score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	
	public Student(Score score) {
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
