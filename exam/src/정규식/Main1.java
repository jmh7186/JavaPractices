package Á¤±Ô½Ä;

import java.util.regex.Pattern;

public class Main1 {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$");
		String email = "hong1234@gmail.com";
		boolean rs = pattern.matcher(email).matches();
		System.out.println(rs);
	}

}
