package ex230419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("192.168.0.10",9999);
		
		String data;
		while(true) {
			BufferedReader in
			=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			  try {
		      if((data=in.readLine())!=null)
		      System.out.println(data);  
			  }catch(Exception e) {e.printStackTrace();}
			  finally {
				  in.close();
			  }
		}
	}
}
