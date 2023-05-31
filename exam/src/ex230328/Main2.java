package ex230328;

import java.io.IOException;
import java.io.InputStream;
import java.io.*;

public class Main2 {

	public static void main(String[] args) {
		byte[] bytes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        //InputStream is = new ByteArrayInputStream(bytes);
		InputStream is=new InputStream() {
			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		};
        int data;
        while ((data = is.read()) != -1) {
            System.out.print(data);
        }
       
	}

}
