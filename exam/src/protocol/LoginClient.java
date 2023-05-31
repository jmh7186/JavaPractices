package protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class LoginClient {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
		  
		  //if(args.length <2)System.out.println("?‚¬?š©ë²? : java LoginClient ?˜¸?Š¤?Š¸ì£¼ì†Œ ?¬?Š¸ë²ˆí˜¸");

		  Socket socket = new Socket("192.168.0.10", 3000);
		  
		  OutputStream os = socket.getOutputStream();
		  InputStream is = socket.getInputStream();
		  Protocol protocol = new Protocol();
		  byte[] buf = protocol.getPacket();
		  
		  //whileë¬¸ì„ ?‚¬?š©?•˜?Š” ?´?œ  : InputStream ?œ¼ë¡œë??„° ê³„ì† ?½?–´?“¤?´ê¸? ?œ„?•´?„œ...?
		  while(true){
		   
		//?†Œì¼“ì˜ InputStream ?œ¼ë¡œë??„° ?½?–´?“¤?—¬?„œ ë°”ì´?Š¸ë°°ì—´ buf?— ???ž¥?•œ?‹¤. (?„œë²„ë¡œë¶??„° ?˜¨ ê°?)
		   is.read(buf);

		   int packetType = buf[0];
		   protocol.setPacket(packetType, buf);
		   
		   if(packetType == Protocol.PT_EXIT){
		    System.out.println("?´?¼?´?–¸?Š¸ ì¢…ë£Œ");
		    break;
		   }
		   
		   switch(packetType){
		   
		   case Protocol.PT_REQ_LOGIN :
		    System.out.println("?„œë²„ê? ë¡œê·¸?¸? •ë³? ?š”ì²?");
		    BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		    System.out.print("?•„?´?”” : ");
		    String id = userIn.readLine();
		    System.out.print("?•”?˜¸ : ");
		    String pwd = userIn.readLine();

		    //?„œë²„ë¡œ ?Œ¨?‚· ? „?†¡ (ë¡œê·¸?¸ ? •ë³? ? „?†¡)
		    protocol = new Protocol(Protocol.PT_RES_LOGIN);
		    protocol.setId(id);
		    protocol.setPassword(pwd);
		    System.out.println("ë¡œê·¸?¸ ? •ë³? ? „?†¡");
		    os.write(protocol.getPacket());
		    break;
		    
		   case Protocol.PT_LOGIN_RESULT :
		    System.out.println("?„œë²„ê? ë¡œê·¸?¸ ê²°ê³¼ ? „?†¡");
		    String result = protocol.getLoginResult();
		    if(result.equals("1")){
		     System.out.println("ë¡œê·¸?¸ ?„±ê³?");
		    }else if(result.equals("2")){
		     System.out.println("?•”?˜¸ ??ë¦?");
		    }else if(result.equals("3")){
		     System.out.println("ì¡´ìž¬?•˜ì§? ?•Š?Š” ?•„?´?””");
		    }
		    protocol = new Protocol(Protocol.PT_EXIT);
		    System.out.println("ì¢…ë£Œ?Œ¨?‚· ? „?†¡");
		    break;
		   }
		   
		  }//end while

		  os.close();
		  is.close();
		  socket.close();
		 }
}
