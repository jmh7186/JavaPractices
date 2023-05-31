package ex230321;

import java.io.IOException;

public class Main7 {

	public static void main(String[] args) throws IOException {
		System.out.println(System.in.available());
		System.in.read();
		System.out.println(System.in.available());
		while(System.in.available()!=0) {
			System.out.println((char)System.in.read());
		}
		System.out.println("반복문 빠져나옴");
		System.out.println(System.in.available());
	}

}
