package protocol;

import java.io.Serializable;

public class Protocol implements Serializable{

 //?��로토�? ???��?�� �??�� �??��
 public static final int PT_UNDEFINED = -1;   //?��로토콜이 �??��?��?�� ?���? ?��?�� 경우?��
 public static final int PT_EXIT = 0;
 public static final int PT_REQ_LOGIN = 1;   //로그?��?���?
 public static final int PT_RES_LOGIN = 2;   //?��증요�?
 public static final int PT_LOGIN_RESULT = 3;  //?��증결�?
 public static final int LEN_LOGIN_ID = 20;   //ID길이
 public static final int LEN_LOGIN_PASSWORD = 20; //PW길이
 public static final int LEN_LOGIN_RESULT = 2;  //로그?��?��증값 길이
 public static final int LEN_PROTOCOL_TYPE = 1;  //?��로토콜�??�� 길이
 public static final int LEN_MAX = 1000;    //최�? ?��?��?? 길이
 
 protected int protocolType;
 
 private byte[] packet;   //?��로토콜과 ?��?��?��?�� ???��공간?�� ?��?�� 바이?��배열

//?��?��?��
 public Protocol(){
  this(PT_UNDEFINED);
 }
 
//?��?��?��
 public Protocol(int protocolType){

  this.protocolType = protocolType;
  
//?��?�� ?��?���? ?��?��?��?�� ?��?�� Protocol ?��?��?���? ?��?��?��?��?��?�� ?��?��?�� 바이?��배열 packet ?�� length �? 결정?��?��.
  getPacket(protocolType);
 }
 
 
 public byte[] getPacket(int protocolType){
  
  if(packet == null){
   
   switch(protocolType){
   
    case PT_REQ_LOGIN : packet = new byte[LEN_PROTOCOL_TYPE]; break;
    case PT_RES_LOGIN : packet = new byte[LEN_PROTOCOL_TYPE + LEN_LOGIN_ID + LEN_LOGIN_PASSWORD]; break;
    case PT_UNDEFINED : packet = new byte[LEN_MAX]; break;
    case PT_LOGIN_RESULT : packet = new byte[LEN_PROTOCOL_TYPE + LEN_LOGIN_RESULT]; break;
    case PT_EXIT : packet = new byte[LEN_PROTOCOL_TYPE]; break;
   }
  }

  packet[0] = (byte)protocolType;   //packet 바이?��배열?�� 첫번�? 방에 ?��로토콜�??�� ?��?���? ?��?��?�� ?��?��?��.
  return packet;
 }

 //로그?��?�� ?���?/?��?��?�� 결과값을 ?��로토콜로 �??�� 추출?��?�� 문자?���? 리턴
 public String getLoginResult(){
  //String?�� ?��?�� ?��?��?���? ?��?�� : String(byte[] bytes, int offset, int length)
  return new String(packet, LEN_PROTOCOL_TYPE, LEN_LOGIN_RESULT).trim();
 }
 
 
 //String ok�? byte[] �? 만들?��?�� packet?�� ?��로토�? ???�� 바로 ?��?�� 추�??��?��.
 public void setLoginResult(String ok){
  //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
  System.arraycopy(ok.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE, ok.trim().getBytes().length);
 }
 
 
 public void setProtocolType(int protocolType){
  this.protocolType = protocolType;
 }

 
 public int getProtocolType(){
  return protocolType;
 }
 
 
 public byte[] getPacket(){
  return packet;
 }
 
 
 //Default ?��?��?���? ?��?��?�� ?�� Protocol ?��?��?��?�� packet ?��?��??�? 바꾸�? ?��?�� 메서?��
 public void setPacket(int pt, byte[] buf){
  packet = null;
  packet = getPacket(pt);
  protocolType = pt;
  System.arraycopy(buf, 0, packet, 0, packet.length);
 }
 
 
 public String getId(){
  //String(byte[] bytes, int offset, int length)
  return new String(packet, LEN_PROTOCOL_TYPE, LEN_LOGIN_ID).trim();
 }
 
 
 //byte[] packet ?�� String ID�? byte[]�? 만들?�� ?��로토�? ???�� 바로 ?���?분에 추�??��?��.
 public void setId(String id){
  System.arraycopy(id.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE, id.trim().getBytes().length);
 }
 
 
 public String getPassword(){
  //구성?���? 보아 ?��?��?��?��?�� byte[] ?��?�� 로그?�� ?��?��?�� 바로 ?���?분에 ?��?���??�� ?�� ?��?��.
  return new String(packet, LEN_PROTOCOL_TYPE + LEN_LOGIN_ID, LEN_LOGIN_PASSWORD).trim();
 }
 
 
 public void setPassword(String password){
  System.arraycopy(password.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE+LEN_LOGIN_ID, password.trim().getBytes().length);
  packet[LEN_PROTOCOL_TYPE + LEN_LOGIN_ID + password.trim().getBytes().length] = '\0';
 }
  
}
