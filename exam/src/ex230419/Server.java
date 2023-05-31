package ex230419;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

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
		BufferedReader in
		=new BufferedReader(new InputStreamReader(client.getInputStream()));
		BufferedWriter out
		=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		int position=0;
		while(true) {
			//요청한 데이터를 수신
			String id=in.readLine(); 
			//검색을하여 위치확인
			for(int i=0;i<student.length;i++) {
				if(student[i].id.equals(id)) {
					position=i;
					break;
				}
			}
			//데이터를 찾았으면 해당하는 배열 클래스 위치의 데이터를 전송
			ObjectOutputStream obj=
					new ObjectOutputStream(client.getOutputStream());
			obj.writeObject(student[position]);
			obj.flush();
		}

	}

}
