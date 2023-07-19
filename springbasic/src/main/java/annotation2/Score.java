package annotation2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //xml Beam 持失 -> annotation生稽 持失
public class Score {
	@Value("100")
	int kor;
	@Value("90")
	int eng;
	@Value("80")
	int math;
	
	public Score() {}
	
	public Score(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Score [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
}
