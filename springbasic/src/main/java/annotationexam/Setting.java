package annotationexam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Setting {
	
	@Bean
	public ConsolePrint consolePrint() {
		return new ConsolePrint();
	}
	
	@Bean
	public GridPrint gridPrint() {
		return new GridPrint();
	}
}
