package vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PhonebookVO {
	private String idx;
	private String name;
	private String hp;
	private String company;
	private String email;
	private String birthday;
	private String address;
	private String memo;
}
