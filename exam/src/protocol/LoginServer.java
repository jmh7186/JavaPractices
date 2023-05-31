package protocol;

import java.net.*;
import java.io.*;

public class LoginServer {

 public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
  
  ServerSocket sSocket = new ServerSocket(3000);
  System.out.println("?´?¼?´?–¸?Š¸ ? ‘?† ??ê¸°ì¤‘ ...");
  Socket socket = sSocket.accept();
  System.out.println("?´?¼?´?–¸?Š¸ ? ‘?†");
  
//?–´ì°¨í”¼ ë°”ì´?Š¸ë°°ì—´ë¡? ? „?†¡?•  ê²ƒì´ê¸? ?•Œë¬¸ì— ?•„?„°?Š¤?Š¸ë¦? ?—†?´ Input/OutputStreamë§? ?‚¬?š©?•´?„ ?œ?‹¤.
  OutputStream os = socket.getOutputStream();
  InputStream is = socket.getInputStream();

  //ë¡œê·¸?¸? •ë³? ?š”ì²??š© ?”„ë¡œí† ì½? ê°ì²´ ?ƒ?„±
  Protocol protocol = new Protocol(Protocol.PT_REQ_LOGIN);
  
  //ë¡œê·¸?¸? •ë³? ?š”ì²? ?Œ¨?‚·?„ ? „?†¡ 
  os.write(protocol.getPacket());
  

  while(true){
  
   //?ƒˆ Protocol ê°ì²´ ?ƒ?„± (ê¸°ë³¸ ?ƒ?„±?)
   protocol = new Protocol();
   
   //ê¸°ë³¸ ?ƒ?„±?ë¡? ?ƒ?„±?•  ?•Œ?—?Š” ë°”ì´?Š¸ë°°ì—´?˜ ê¸¸ì´ê°? 1000?œ¼ë¡? ì§?? •?¨
   byte[] buf = protocol.getPacket();
   
   //socket?œ¼ë¡œë??„° ?½?–´?„œ(?´?¼?´?–¸?Š¸?˜ ?…? ¥) buf ?— ???¥?•œ?‹¤. (ë¸”ë¡œ?‚¹ë©”ì„œ?“œ)
   is.read(buf);
   
   //?Œ¨?‚· ???…?„ ?–»ê³? Protocol ê°ì²´?˜ packet ë©¤ë²„ë³??ˆ˜?— bufë¥? ë³µì‚¬?•œ?‹¤.
   int packetType = buf[0];
   protocol.setPacket(packetType, buf);
   
   if(packetType == Protocol.PT_EXIT){
    protocol = new Protocol(Protocol.PT_EXIT);
    os.write(protocol.getPacket());
    System.out.println("?„œë²„ì¢…ë£?");
    break;
   }
  
   
   switch(packetType){
   
   //?´?¼?´?–¸?Š¸ê°? ë¡œê·¸?¸ ? •ë³? ?‘?‹µ ?Œ¨?‚·?¸ ê²½ìš° (?´?¼?´?–¸?Š¸?˜ ë¡œê·¸?¸ ? •ë³? ? „?†¡?¼ ê²½ìš°)
   case Protocol.PT_RES_LOGIN :
    
    System.out.println("?´?¼?´?–¸?Š¸ê°? ë¡œê·¸?¸ ? •ë³´ë?? ë³´ëƒˆ?Šµ?‹ˆ?‹¤.");
    String id = protocol.getId();
    String password = protocol.getPassword();
    System.out.println(id+"@@"+password+"@@");
    
    if(id.equals("test")){
     
     if(password.equals("1111")){
      
      //ë¡œê·¸?¸ ?„±ê³?
      protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
      protocol.setLoginResult("1");
      System.out.println("ë¡œê·¸?¸ ?„±ê³?");
     
     }else{
      
      //?•”?˜¸ ??ë¦?
      protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
      protocol.setLoginResult("2");
      System.out.println("?•”?˜¸ ??ë¦?");
     }
     
    }else{
     
     //?•„?´?”” ì¡´ì¬ ?•ˆ?•¨
     protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
     protocol.setLoginResult("3");
     System.out.println("?•„?´?”” ì¡´ì¬ ?•ˆ?•¨");
    }
   
    System.out.println("ë¡œê·¸?¸ ì²˜ë¦¬ ê²°ê³¼ ? „?†¡");
    os.write(protocol.getPacket()); //socket?˜ OutputStream ?— ê¸°ë¡?•œ?‹¤.
    break;
   
   }//end switch
  
  }//end while
  
  is.close();
  os.close();
  socket.close();
 
 }
 
}