package framelogin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main1 {

	public static void main(String[] args) {
		Date date = new Date();
		int d=date.getYear();
		System.out.println(d);
		d=date.getMonth();
		System.out.println(d);
		d=date.getDay();
		System.out.println(d);
		
		String dat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		System.out.println(dat);

	}

}
