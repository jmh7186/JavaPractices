package ex230322;

public class StudentSungjuk {
	//학생은 성적을 가진다.
	Student student;
	Sungjuk sj;	
	public StudentSungjuk() {
		// TODO Auto-generated constructor stub
	}
	public StudentSungjuk(Student student, Sungjuk sj) {
		this.student = student;
		this.sj = sj;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Sungjuk getSj() {
		return sj;
	}
	public void setSj(Sungjuk sj) {
		this.sj = sj;
	}
	@Override
	public String toString() {
		return "StudentSungjuk [student=" + student + ", sj=" + sj + "]";
	}
	
	
}
