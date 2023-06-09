package protocol;

import java.io.Serializable;

public class Protocol implements Serializable{

 //?λ‘ν μ½? ???? κ΄?? λ³??
 public static final int PT_UNDEFINED = -1;   //?λ‘ν μ½μ΄ μ§?? ??΄ ?μ§? ?? κ²½μ°?
 public static final int PT_EXIT = 0;
 public static final int PT_REQ_LOGIN = 1;   //λ‘κ·Έ?Έ?μ²?
 public static final int PT_RES_LOGIN = 2;   //?Έμ¦μμ²?
 public static final int PT_LOGIN_RESULT = 3;  //?Έμ¦κ²°κ³?
 public static final int LEN_LOGIN_ID = 20;   //IDκΈΈμ΄
 public static final int LEN_LOGIN_PASSWORD = 20; //PWκΈΈμ΄
 public static final int LEN_LOGIN_RESULT = 2;  //λ‘κ·Έ?Έ?Έμ¦κ° κΈΈμ΄
 public static final int LEN_PROTOCOL_TYPE = 1;  //?λ‘ν μ½ν?? κΈΈμ΄
 public static final int LEN_MAX = 1000;    //μ΅λ? ?°?΄?? κΈΈμ΄
 
 protected int protocolType;
 
 private byte[] packet;   //?λ‘ν μ½κ³Ό ?°?΄?°? ???₯κ³΅κ°?΄ ?? λ°μ΄?Έλ°°μ΄

//??±?
 public Protocol(){
  this(PT_UNDEFINED);
 }
 
//??±?
 public Protocol(int protocolType){

  this.protocolType = protocolType;
  
//?΄?€ ??λ₯? ??±?? ?£?΄ Protocol ?΄??€λ₯? ??±???? ?°?Ό? λ°μ΄?Έλ°°μ΄ packet ? length κ°? κ²°μ ??€.
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

  packet[0] = (byte)protocolType;   //packet λ°μ΄?Έλ°°μ΄? μ²«λ²μ§? λ°©μ ?λ‘ν μ½ν?? ??λ₯? ???΄ ???€.
  return packet;
 }

 //λ‘κ·Έ?Έ? ?±κ³?/?€?¨? κ²°κ³Όκ°μ ?λ‘ν μ½λ‘ λΆ??° μΆμΆ??¬ λ¬Έμ?΄λ‘? λ¦¬ν΄
 public String getLoginResult(){
  //String? ?€? ??±?λ₯? ?¬?© : String(byte[] bytes, int offset, int length)
  return new String(packet, LEN_PROTOCOL_TYPE, LEN_LOGIN_RESULT).trim();
 }
 
 
 //String okλ₯? byte[] λ‘? λ§λ€?΄? packet? ?λ‘ν μ½? ??? λ°λ‘ ?€? μΆκ???€.
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
 
 
 //Default ??±?λ‘? ??±? ? Protocol ?΄??€? packet ?°?΄??λ₯? λ°κΎΈκΈ? ?? λ©μ?
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
 
 
 //byte[] packet ? String IDλ₯? byte[]λ‘? λ§λ€?΄ ?λ‘ν μ½? ??? λ°λ‘ ?·λΆ?λΆμ μΆκ???€.
 public void setId(String id){
  System.arraycopy(id.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE, id.trim().getBytes().length);
 }
 
 
 public String getPassword(){
  //κ΅¬μ±?Όλ‘? λ³΄μ ?¨?€??? byte[] ?? λ‘κ·Έ?Έ ??΄? λ°λ‘ ?·λΆ?λΆμ ?€?΄κ°?? ?― ??€.
  return new String(packet, LEN_PROTOCOL_TYPE + LEN_LOGIN_ID, LEN_LOGIN_PASSWORD).trim();
 }
 
 
 public void setPassword(String password){
  System.arraycopy(password.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE+LEN_LOGIN_ID, password.trim().getBytes().length);
  packet[LEN_PROTOCOL_TYPE + LEN_LOGIN_ID + password.trim().getBytes().length] = '\0';
 }
  
}
