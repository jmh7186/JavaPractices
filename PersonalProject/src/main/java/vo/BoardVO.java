package vo;

import java.sql.Date;

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
public class BoardVO {
	int idx;
	String title;
	String content;
	int viewcount;
	int parentid;
	int tab;
	String writeid;
	String writename;
	Date writeday;
	String filename;
	int isdel;
	String kind;
}
