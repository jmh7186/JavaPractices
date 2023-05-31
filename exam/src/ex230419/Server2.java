package ex230419;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

	public static void main(String[] args) throws IOException {
		//데이터 준비
		Student[] student=new Student[5];
		student[0]=new Student("20000101","홍길동", 100, 100, 100);
		student[1]=new Student("20000102","유길동", 90, 90, 90);
		student[2]=new Student("20000103","이길동", 80, 80, 80);
		student[3]=new Student("20000104","박길동", 70, 70, 70);
		student[4]=new Student("20000105","정길동", 60, 60, 60);
				
		ServerSocket server=new ServerSocket(9999);
		System.out.println("서버대기중.....");
		Socket client=server.accept();
		System.out.println(client.getInetAddress()+"클라이언트 접속");
		//소켓을 통해 입력되고 출력되는 통로를 미리 생성
		DataInputStream in
		=new DataInputStream(client.getInputStream());
		DataOutputStream out
		=new DataOutputStream(client.getOutputStream());
		int position=0;
		while(true) {
			//접속과 동시에 메뉴를 클라이언트에게 전송
			String menu="1.입력\n2.전체출력\n3.수정\n4.삭제\n";
			out.writeUTF(menu);
			out.flush();
			
			//메뉴번호를 수신
			String select=in.readUTF();
					
			switch(select) {
			case "1" : System.out.println("1번출력합니다."); break;
			case "2" : System.out.println("2번출력합니다."); break;
			case "3" : System.out.println("3번출력합니다."); break;
			case "4" : System.out.println("4번출력합니다."); break;
			}
		}	

	}

}
