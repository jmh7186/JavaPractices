package ex230424;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Client4 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			
			ObjectOutputStream out
			=new ObjectOutputStream(socket.getOutputStream());
			
			//프로토콜 타입이 로그인이여서 패킷을 만들다고 가정할 경우
			//아이디 : 패킷크기 10byte, 패스워드 :패킷크기 10byte, 전체 패킷길이 : 4byte사용
			//아이디길이+패스워드길이+전체패킷길이=총 패킷의 길이은 24
			int len=24;
			//전송할 데이터는 저장할 클래스
			NewProtocol data=new NewProtocol(len);
			//각각의 문자열을 byte배열에 입력해줌 
			String id="admin";
			String pass="1234";
			//int len=id.length()+pass.length();
			
			/* 여기서 부터 패킷을 만드는 작업 */
			System.arraycopy
			(id.getBytes(),0, data.packet, 0, id.length());
			
			System.arraycopy
			(pass.getBytes(),0, data.packet, 10, pass.length());
			
			//정수형 변수 len의 값을 4바이트 배열로 만들고(첫번째 입력)
			//data.packet에 20번째자리에서 4바이트를 복사를 한다.(세번째 입력~다섯번째입력)
			System.arraycopy
			(ByteBuffer.allocate(4).putInt(len).array(),0,data.packet,20,4);
			/* 패킷작업 완료 */
			
			out.writeObject(data);
			out.flush();
			//데이터전송시 시스템지연을 통해 데이터가 수신할 시간을 제공해야함.
			Thread.sleep(1000);//******************
			System.out.println("데이터전송완료");
		}catch(Exception e) {}
		

	}

}
