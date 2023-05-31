package protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class LoginClient {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
		  
		  //if(args.length <2)System.out.println("?��?���? : java LoginClient ?��?��?��주소 ?��?��번호");

		  Socket socket = new Socket("192.168.0.10", 3000);
		  
		  OutputStream os = socket.getOutputStream();
		  InputStream is = socket.getInputStream();
		  Protocol protocol = new Protocol();
		  byte[] buf = protocol.getPacket();
		  
		  //while문을 ?��?��?��?�� ?��?�� : InputStream ?��로�??�� 계속 ?��?��?��?���? ?��?��?��...?
		  while(true){
		   
		//?��켓의 InputStream ?��로�??�� ?��?��?��?��?�� 바이?��배열 buf?�� ???��?��?��. (?��버로�??�� ?�� �?)
		   is.read(buf);

		   int packetType = buf[0];
		   protocol.setPacket(packetType, buf);
		   
		   if(packetType == Protocol.PT_EXIT){
		    System.out.println("?��?��?��?��?�� 종료");
		    break;
		   }
		   
		   switch(packetType){
		   
		   case Protocol.PT_REQ_LOGIN :
		    System.out.println("?��버�? 로그?��?���? ?���?");
		    BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		    System.out.print("?��?��?�� : ");
		    String id = userIn.readLine();
		    System.out.print("?��?�� : ");
		    String pwd = userIn.readLine();

		    //?��버로 ?��?�� ?��?�� (로그?�� ?���? ?��?��)
		    protocol = new Protocol(Protocol.PT_RES_LOGIN);
		    protocol.setId(id);
		    protocol.setPassword(pwd);
		    System.out.println("로그?�� ?���? ?��?��");
		    os.write(protocol.getPacket());
		    break;
		    
		   case Protocol.PT_LOGIN_RESULT :
		    System.out.println("?��버�? 로그?�� 결과 ?��?��");
		    String result = protocol.getLoginResult();
		    if(result.equals("1")){
		     System.out.println("로그?�� ?���?");
		    }else if(result.equals("2")){
		     System.out.println("?��?�� ??�?");
		    }else if(result.equals("3")){
		     System.out.println("존재?���? ?��?�� ?��?��?��");
		    }
		    protocol = new Protocol(Protocol.PT_EXIT);
		    System.out.println("종료?��?�� ?��?��");
		    break;
		   }
		   
		  }//end while

		  os.close();
		  is.close();
		  socket.close();
		 }
}
