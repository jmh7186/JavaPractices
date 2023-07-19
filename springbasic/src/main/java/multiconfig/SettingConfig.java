package multiconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import multiconfig.score.Score;
import multiconfig.student.Student;

@Configuration
//@ComponentScan("multiconfig.Student") //컴포넌트들이 두 패키지로 나뉘어 있으므로 찾지 못함
//@ComponentScan //같은 패키지로 묶여있어 찾을 수 있음
// 아래 두 코드는 각각 스캔 위치를 정해줄 수 있음
//@ComponentScan(basePackages = {"multiconfig.Student", "multiconfig.Score"})
@ComponentScan(basePackageClasses = { Score.class, Student.class })
public class SettingConfig {

}
