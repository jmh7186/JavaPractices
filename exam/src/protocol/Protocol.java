package protocol;

import java.io.Serializable;

public class Protocol implements Serializable{

 //?”„ë¡œí† ì½? ???…?— ê´??•œ ë³??ˆ˜
 public static final int PT_UNDEFINED = -1;   //?”„ë¡œí† ì½œì´ ì§?? •?˜?–´ ?ˆì§? ?•Š?„ ê²½ìš°?—
 public static final int PT_EXIT = 0;
 public static final int PT_REQ_LOGIN = 1;   //ë¡œê·¸?¸?š”ì²?
 public static final int PT_RES_LOGIN = 2;   //?¸ì¦ìš”ì²?
 public static final int PT_LOGIN_RESULT = 3;  //?¸ì¦ê²°ê³?
 public static final int LEN_LOGIN_ID = 20;   //IDê¸¸ì´
 public static final int LEN_LOGIN_PASSWORD = 20; //PWê¸¸ì´
 public static final int LEN_LOGIN_RESULT = 2;  //ë¡œê·¸?¸?¸ì¦ê°’ ê¸¸ì´
 public static final int LEN_PROTOCOL_TYPE = 1;  //?”„ë¡œí† ì½œí??… ê¸¸ì´
 public static final int LEN_MAX = 1000;    //ìµœë? ?°?´?? ê¸¸ì´
 
 protected int protocolType;
 
 private byte[] packet;   //?”„ë¡œí† ì½œê³¼ ?°?´?„°?˜ ???¥ê³µê°„?´ ?˜?Š” ë°”ì´?Š¸ë°°ì—´

//?ƒ?„±?
 public Protocol(){
  this(PT_UNDEFINED);
 }
 
//?ƒ?„±?
 public Protocol(int protocolType){

  this.protocolType = protocolType;
  
//?–´?–¤ ?ƒ?ˆ˜ë¥? ?ƒ?„±??— ?„£?–´ Protocol ?´?˜?Š¤ë¥? ?ƒ?„±?•˜?Š?ƒ?— ?”°?¼?„œ ë°”ì´?Š¸ë°°ì—´ packet ?˜ length ê°? ê²°ì •?œ?‹¤.
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

  packet[0] = (byte)protocolType;   //packet ë°”ì´?Š¸ë°°ì—´?˜ ì²«ë²ˆì§? ë°©ì— ?”„ë¡œí† ì½œí??… ?ƒ?ˆ˜ë¥? ?…‹?Œ…?•´ ?†“?Š”?‹¤.
  return packet;
 }

 //ë¡œê·¸?¸?›„ ?„±ê³?/?‹¤?Œ¨?˜ ê²°ê³¼ê°’ì„ ?”„ë¡œí† ì½œë¡œ ë¶??„° ì¶”ì¶œ?•˜?—¬ ë¬¸ì?—´ë¡? ë¦¬í„´
 public String getLoginResult(){
  //String?˜ ?‹¤?Œ ?ƒ?„±?ë¥? ?‚¬?š© : String(byte[] bytes, int offset, int length)
  return new String(packet, LEN_PROTOCOL_TYPE, LEN_LOGIN_RESULT).trim();
 }
 
 
 //String okë¥? byte[] ë¡? ë§Œë“¤?–´?„œ packet?˜ ?”„ë¡œí† ì½? ???… ë°”ë¡œ ?’¤?— ì¶”ê??•œ?‹¤.
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
 
 
 //Default ?ƒ?„±?ë¡? ?ƒ?„±?•œ ?›„ Protocol ?´?˜?Š¤?˜ packet ?°?´??ë¥? ë°”ê¾¸ê¸? ?œ„?•œ ë©”ì„œ?“œ
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
 
 
 //byte[] packet ?— String IDë¥? byte[]ë¡? ë§Œë“¤?–´ ?”„ë¡œí† ì½? ???… ë°”ë¡œ ?’·ë¶?ë¶„ì— ì¶”ê??•œ?‹¤.
 public void setId(String id){
  System.arraycopy(id.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE, id.trim().getBytes().length);
 }
 
 
 public String getPassword(){
  //êµ¬ì„±?œ¼ë¡? ë³´ì•„ ?Œ¨?Š¤?›Œ?“œ?Š” byte[] ?—?„œ ë¡œê·¸?¸ ?•„?´?”” ë°”ë¡œ ?’·ë¶?ë¶„ì— ?“¤?–´ê°??Š” ?“¯ ?•˜?‹¤.
  return new String(packet, LEN_PROTOCOL_TYPE + LEN_LOGIN_ID, LEN_LOGIN_PASSWORD).trim();
 }
 
 
 public void setPassword(String password){
  System.arraycopy(password.trim().getBytes(), 0, packet, LEN_PROTOCOL_TYPE+LEN_LOGIN_ID, password.trim().getBytes().length);
  packet[LEN_PROTOCOL_TYPE + LEN_LOGIN_ID + password.trim().getBytes().length] = '\0';
 }
  
}
