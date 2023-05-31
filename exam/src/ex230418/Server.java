package ex230418;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		//db구축
		String[] id= {"20000101","20000102","20000103","20000104","20000105"};
		String[] name= {"홍길동","이길동","박길동","유길동","조길동"};
		int[] kor= {100,90,80,70,60};
		int[] eng= {100,90,80,70,60};
		int[] math= {100,90,80,70,60};
		int position=0;
		
		ServerSocket server=new ServerSocket(9999);
		while(true) {
		System.out.println("클라이언트 접속 대기중(서버프로그램)");
		Socket client=server.accept();
		System.out.println("서버 프로그램");
		
		while(true) {
			BufferedReader in=
			new BufferedReader(new InputStreamReader(client.getInputStream()));
			String _id=in.readLine(); //전송된 데이터를 수신
			
			if(_id.equals("exit")) {
				client.close();
				System.out.println("클라이언트 접속종료");
				break;
			}
			
			//검색을하여 위치확인
			for(int i=0;i<id.length;i++) {
				if(id[i].equals(_id)) {
					position=i;
					break;
				}
			}
			
			//해당하는 위치의 데이터를 프로토콜을 만들어야 함.
			StringBuffer buf=new StringBuffer();
			buf.append(id[position]); buf.append(" ");
			buf.append(name[position]); buf.append(" ");
			buf.append(kor[position]); buf.append(" ");
			buf.append(eng[position]); buf.append(" ");
			buf.append(math[position]); buf.append("\n");
			
			//요청한 데이터 전송
			BufferedWriter out
			=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			out.write(buf.toString());
			out.flush();
			
			
		}
		
		}

	}

}
