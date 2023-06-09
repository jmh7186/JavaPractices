package protocol;

import java.net.*;
import java.io.*;

public class LoginServer {

 public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
  
  ServerSocket sSocket = new ServerSocket(3000);
  System.out.println("?΄?Ό?΄?Έ?Έ ? ? ??κΈ°μ€ ...");
  Socket socket = sSocket.accept();
  System.out.println("?΄?Ό?΄?Έ?Έ ? ?");
  
//?΄μ°¨νΌ λ°μ΄?Έλ°°μ΄λ‘? ? ?‘?  κ²μ΄κΈ? ?λ¬Έμ ??°?€?Έλ¦? ??΄ Input/OutputStreamλ§? ?¬?©?΄? ??€.
  OutputStream os = socket.getOutputStream();
  InputStream is = socket.getInputStream();

  //λ‘κ·Έ?Έ? λ³? ?μ²??© ?λ‘ν μ½? κ°μ²΄ ??±
  Protocol protocol = new Protocol(Protocol.PT_REQ_LOGIN);
  
  //λ‘κ·Έ?Έ? λ³? ?μ²? ?¨?·? ? ?‘ 
  os.write(protocol.getPacket());
  

  while(true){
  
   //? Protocol κ°μ²΄ ??± (κΈ°λ³Έ ??±?)
   protocol = new Protocol();
   
   //κΈ°λ³Έ ??±?λ‘? ??±?  ??? λ°μ΄?Έλ°°μ΄? κΈΈμ΄κ°? 1000?Όλ‘? μ§?? ?¨
   byte[] buf = protocol.getPacket();
   
   //socket?Όλ‘λ??° ?½?΄?(?΄?Ό?΄?Έ?Έ? ?? ₯) buf ? ???₯??€. (λΈλ‘?Ήλ©μ?)
   is.read(buf);
   
   //?¨?· ???? ?»κ³? Protocol κ°μ²΄? packet λ©€λ²λ³??? bufλ₯? λ³΅μ¬??€.
   int packetType = buf[0];
   protocol.setPacket(packetType, buf);
   
   if(packetType == Protocol.PT_EXIT){
    protocol = new Protocol(Protocol.PT_EXIT);
    os.write(protocol.getPacket());
    System.out.println("?λ²μ’λ£?");
    break;
   }
  
   
   switch(packetType){
   
   //?΄?Ό?΄?Έ?Έκ°? λ‘κ·Έ?Έ ? λ³? ??΅ ?¨?·?Έ κ²½μ° (?΄?Ό?΄?Έ?Έ? λ‘κ·Έ?Έ ? λ³? ? ?‘?Ό κ²½μ°)
   case Protocol.PT_RES_LOGIN :
    
    System.out.println("?΄?Ό?΄?Έ?Έκ°? λ‘κ·Έ?Έ ? λ³΄λ?? λ³΄λ?΅??€.");
    String id = protocol.getId();
    String password = protocol.getPassword();
    System.out.println(id+"@@"+password+"@@");
    
    if(id.equals("test")){
     
     if(password.equals("1111")){
      
      //λ‘κ·Έ?Έ ?±κ³?
      protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
      protocol.setLoginResult("1");
      System.out.println("λ‘κ·Έ?Έ ?±κ³?");
     
     }else{
      
      //??Έ ??λ¦?
      protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
      protocol.setLoginResult("2");
      System.out.println("??Έ ??λ¦?");
     }
     
    }else{
     
     //??΄? μ‘΄μ¬ ??¨
     protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
     protocol.setLoginResult("3");
     System.out.println("??΄? μ‘΄μ¬ ??¨");
    }
   
    System.out.println("λ‘κ·Έ?Έ μ²λ¦¬ κ²°κ³Ό ? ?‘");
    os.write(protocol.getPacket()); //socket? OutputStream ? κΈ°λ‘??€.
    break;
   
   }//end switch
  
  }//end while
  
  is.close();
  os.close();
  socket.close();
 
 }
 
}