package ex230322_1;
//성적은 국어, 영어, 수학, 합계, 평균이 있다.
public class Score {

	private int kor;
	private int eng;
	private int math;
	private int total;
	private float avg;
	
	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Score(int kor, int eng, int math) {
		
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor+eng+math;
		this.avg = (float)total/3;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Score [kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total + ", avg=" + avg + "]";
	}
	
	
}
