package protocol;

import java.net.*;
import java.io.*;

public class LoginServer {

 public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
  
  ServerSocket sSocket = new ServerSocket(3000);
  System.out.println("?��?��?��?��?�� ?��?�� ??기중 ...");
  Socket socket = sSocket.accept();
  System.out.println("?��?��?��?��?�� ?��?��");
  
//?��차피 바이?��배열�? ?��?��?�� 것이�? ?��문에 ?��?��?��?���? ?��?�� Input/OutputStream�? ?��?��?��?�� ?��?��.
  OutputStream os = socket.getOutputStream();
  InputStream is = socket.getInputStream();

  //로그?��?���? ?���??�� ?��로토�? 객체 ?��?��
  Protocol protocol = new Protocol(Protocol.PT_REQ_LOGIN);
  
  //로그?��?���? ?���? ?��?��?�� ?��?�� 
  os.write(protocol.getPacket());
  

  while(true){
  
   //?�� Protocol 객체 ?��?�� (기본 ?��?��?��)
   protocol = new Protocol();
   
   //기본 ?��?��?���? ?��?��?�� ?��?��?�� 바이?��배열?�� 길이�? 1000?���? �??��?��
   byte[] buf = protocol.getPacket();
   
   //socket?��로�??�� ?��?��?��(?��?��?��?��?��?�� ?��?��) buf ?�� ???��?��?��. (블로?��메서?��)
   is.read(buf);
   
   //?��?�� ???��?�� ?���? Protocol 객체?�� packet 멤버�??��?�� buf�? 복사?��?��.
   int packetType = buf[0];
   protocol.setPacket(packetType, buf);
   
   if(packetType == Protocol.PT_EXIT){
    protocol = new Protocol(Protocol.PT_EXIT);
    os.write(protocol.getPacket());
    System.out.println("?��버종�?");
    break;
   }
  
   
   switch(packetType){
   
   //?��?��?��?��?���? 로그?�� ?���? ?��?�� ?��?��?�� 경우 (?��?��?��?��?��?�� 로그?�� ?���? ?��?��?�� 경우)
   case Protocol.PT_RES_LOGIN :
    
    System.out.println("?��?��?��?��?���? 로그?�� ?��보�?? 보냈?��?��?��.");
    String id = protocol.getId();
    String password = protocol.getPassword();
    System.out.println(id+"@@"+password+"@@");
    
    if(id.equals("test")){
     
     if(password.equals("1111")){
      
      //로그?�� ?���?
      protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
      protocol.setLoginResult("1");
      System.out.println("로그?�� ?���?");
     
     }else{
      
      //?��?�� ??�?
      protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
      protocol.setLoginResult("2");
      System.out.println("?��?�� ??�?");
     }
     
    }else{
     
     //?��?��?�� 존재 ?��?��
     protocol = new Protocol(Protocol.PT_LOGIN_RESULT);
     protocol.setLoginResult("3");
     System.out.println("?��?��?�� 존재 ?��?��");
    }
   
    System.out.println("로그?�� 처리 결과 ?��?��");
    os.write(protocol.getPacket()); //socket?�� OutputStream ?�� 기록?��?��.
    break;
   
   }//end switch
  
  }//end while
  
  is.close();
  os.close();
  socket.close();
 
 }
 
}