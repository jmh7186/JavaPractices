package protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class LoginClient {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
		  
		  //if(args.length <2)System.out.println("?¬?©λ²? : java LoginClient ?Έ?€?Έμ£Όμ ?¬?Έλ²νΈ");

		  Socket socket = new Socket("192.168.0.10", 3000);
		  
		  OutputStream os = socket.getOutputStream();
		  InputStream is = socket.getInputStream();
		  Protocol protocol = new Protocol();
		  byte[] buf = protocol.getPacket();
		  
		  //whileλ¬Έμ ?¬?©?? ?΄?  : InputStream ?Όλ‘λ??° κ³μ ?½?΄?€?΄κΈ? ??΄?...?
		  while(true){
		   
		//?μΌμ InputStream ?Όλ‘λ??° ?½?΄?€?¬? λ°μ΄?Έλ°°μ΄ buf? ???₯??€. (?λ²λ‘λΆ??° ?¨ κ°?)
		   is.read(buf);

		   int packetType = buf[0];
		   protocol.setPacket(packetType, buf);
		   
		   if(packetType == Protocol.PT_EXIT){
		    System.out.println("?΄?Ό?΄?Έ?Έ μ’λ£");
		    break;
		   }
		   
		   switch(packetType){
		   
		   case Protocol.PT_REQ_LOGIN :
		    System.out.println("?λ²κ? λ‘κ·Έ?Έ? λ³? ?μ²?");
		    BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		    System.out.print("??΄? : ");
		    String id = userIn.readLine();
		    System.out.print("??Έ : ");
		    String pwd = userIn.readLine();

		    //?λ²λ‘ ?¨?· ? ?‘ (λ‘κ·Έ?Έ ? λ³? ? ?‘)
		    protocol = new Protocol(Protocol.PT_RES_LOGIN);
		    protocol.setId(id);
		    protocol.setPassword(pwd);
		    System.out.println("λ‘κ·Έ?Έ ? λ³? ? ?‘");
		    os.write(protocol.getPacket());
		    break;
		    
		   case Protocol.PT_LOGIN_RESULT :
		    System.out.println("?λ²κ? λ‘κ·Έ?Έ κ²°κ³Ό ? ?‘");
		    String result = protocol.getLoginResult();
		    if(result.equals("1")){
		     System.out.println("λ‘κ·Έ?Έ ?±κ³?");
		    }else if(result.equals("2")){
		     System.out.println("??Έ ??λ¦?");
		    }else if(result.equals("3")){
		     System.out.println("μ‘΄μ¬?μ§? ?? ??΄?");
		    }
		    protocol = new Protocol(Protocol.PT_EXIT);
		    System.out.println("μ’λ£?¨?· ? ?‘");
		    break;
		   }
		   
		  }//end while

		  os.close();
		  is.close();
		  socket.close();
		 }
}
