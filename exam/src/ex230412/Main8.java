package ex230412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main8 {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(80);
		System.out.println("���� ���� ��...");
		
		Socket socket=serverSocket.accept();
		BufferedReader in = 
		new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        while (true) {
        	String requestLine = in.readLine();
        	System.out.println(requestLine.substring(6,7));
        	if (requestLine.length() == 0) break;
            System.out.println(requestLine);
            
         }
	}

}


//test -> �������� ���� -> http://192.168.0.10:8888
//http://192.168.0.10
//http://192.168.0.10/index.html
//http://192.168.0.10/login.html



