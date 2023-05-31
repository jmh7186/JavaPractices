package myprotocol;
//통신에 필요한 방법을 프로토콜타입으로 정의
//실제 전송은 getPacket()함수를 호출하여 바이트배열로 네트워크로 전송됨.
public class Protocol {
	 public static final int PT_EXIT = 0;
	 public static final int PT_REQ_LOGIN = 1;   //로그인요청
	 public static final int PT_RES_LOGIN = 2;   //인증요청
	 public static final int PT_LOGIN_RESULT = 3;  //인증결과
	 public static final int PT_LOGIN_RESULT_SUCESS = 31; //로그인성공
	 public static final int PT_LOGIN_RESULT_FAIL = 32; //로그인실패
	 public static final int PT_CHAT = 4;
	 
	 int protocolType;
	 byte[] packet;
	 
	 public Protocol() {
		this(-1); //Protocol(int protocolType) 호출과 동일
	}
	 
	 public Protocol(int protocolType) {
		 //프로토콜 타입은 바이트배열(packet)의 크기와 packet[0]타입을 기록한다.
		 this.protocolType=protocolType;
		 switch(protocolType) {
		 case Protocol.PT_REQ_LOGIN :  packet=new byte[1]; break;//서버가 클라이언트에게 로그인 요청
		 case Protocol.PT_RES_LOGIN : packet=new byte[21]; break; //로그인시도; type:1, id:10, pass:10 = 21
		 case Protocol.PT_LOGIN_RESULT : packet=new byte[2]; break;
		 case Protocol.PT_CHAT : packet=new byte[1024]; break;
		 default: packet=new byte[1024];break;
		 }
		 
		 packet[0]=(byte) protocolType;
		 
	}

	public int getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(int protocolType) {
		this.protocolType = protocolType;
	}

	public byte[] getPacket() {
		return packet;
	}

	public void setPacket(byte[] packet) {
		this.packet = packet;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return new String(packet,1,9).trim();
	}
	 
	public String getPassword() {
		// TODO Auto-generated method stub
		return new String(packet,10,9).trim();
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return new String(packet,1,1023).trim();
	}
	
	 
	 
	 
	 
	 
	 
}
