package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {
	String id;
	String name;
//	@Autowired
//	@Qualifier("score1")
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
	
//	@Autowired
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

//	@Autowired
//	@Qualifier("score1")
	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
	}

}
