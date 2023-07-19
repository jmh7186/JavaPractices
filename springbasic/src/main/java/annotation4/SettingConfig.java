package annotation4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SettingConfig {
	
	@Bean(name="s") //이름을 부여하지 않을 경우 객체명의 앞부분을 소문자로 바꾼 값이 변수가 된다.
	public Student student() {
		return new Student();
	}
	
	@Bean
	public Score score() {
		return new Score();
	}
	
	@Bean
	public Score valueScore() {
		return new Score(10,20,30);
	}
	
}