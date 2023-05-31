package ex230322;

public class Sungjuk{
	int year;
	int semester; //1:1학기 2:2학기
	int season; //0:중간, 1:기말
	int kor;
	int eng;
	int math;
	
	public Sungjuk() {
		// TODO Auto-generated constructor stub
	}

	public Sungjuk(int year, int semester, int season, int kor, int eng, int math) {
		
		this.year = year;
		this.semester = semester;
		this.season = season;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Sungjuk [year=" + year + ", semester=" + semester + ", season=" + season + ", kor=" + kor + ", eng="
				+ eng + ", math=" + math + "]";
	}
	
}
