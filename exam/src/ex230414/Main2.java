package ex230414;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main2 {

	public static void main(String[] args) throws IOException {
		//소켓은 네트워크 컴퓨터간의 데이터를 이동하는 통로이다.
		//내PC(192.168.0.10)의 네트워크프로그램(포트80)을 열어두는 상태이다.
		//네트워크 컴퓨터중에(192.168.0.30)인 컴퓨터가 접속을 하기위해서는 프로그램이 필요하고
		//그 프로그램 역시 소켓이 필요함. 소켓이 필요하다는 의미는 포트가 필요하다는 의미
		ServerSocket server=new ServerSocket(80);
		int i=0;
		while(true) {
		System.out.println("서버 접속대기중...... ");
		Socket client=server.accept();
		BufferedReader in = 
		new BufferedReader(new InputStreamReader(client.getInputStream()));
		        
		String requestLine = in.readLine();
		String filename=requestLine.substring(5,15);
		
		//메모리에 보내는 데이터를 적어둠
		String senddata=
		"HTTP/1.1 200 OK Content-Type:text/html;charset=utf-8\r\n\n";

		//변수에 있는 데이터 대신 파일 데이터를 이용할 경우 어떻게 할 것인가?
		//senddata+="<h1 style='color:green'>teacher com에 클라이언트 접속</h1>"+(i++);
		FileInputStream file=new FileInputStream(filename);
		String fdata=new String(file.readAllBytes());
		senddata+=fdata;
		client.getOutputStream().write(senddata.getBytes());
		client.getOutputStream().flush();
		client.close();
		}
	}

}
