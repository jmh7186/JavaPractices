package ex230327;

import java.text.DecimalFormat;

public class Main10 {

	public static void main(String[] args) {
		DecimalFormat comma = new DecimalFormat("###,##0");
		System.out.println(comma.format(100000000));
	}

}
