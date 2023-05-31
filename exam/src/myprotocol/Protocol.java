package myprotocol;
//��ſ� �ʿ��� ����� ��������Ÿ������ ����
//���� ������ getPacket()�Լ��� ȣ���Ͽ� ����Ʈ�迭�� ��Ʈ��ũ�� ���۵�.
public class Protocol {
	 public static final int PT_EXIT = 0;
	 public static final int PT_REQ_LOGIN = 1;   //�α��ο�û
	 public static final int PT_RES_LOGIN = 2;   //������û
	 public static final int PT_LOGIN_RESULT = 3;  //�������
	 public static final int PT_LOGIN_RESULT_SUCESS = 31; //�α��μ���
	 public static final int PT_LOGIN_RESULT_FAIL = 32; //�α��ν���
	 public static final int PT_CHAT = 4;
	 
	 int protocolType;
	 byte[] packet;
	 
	 public Protocol() {
		this(-1); //Protocol(int protocolType) ȣ��� ����
	}
	 
	 public Protocol(int protocolType) {
		 //�������� Ÿ���� ����Ʈ�迭(packet)�� ũ��� packet[0]Ÿ���� ����Ѵ�.
		 this.protocolType=protocolType;
		 switch(protocolType) {
		 case Protocol.PT_REQ_LOGIN :  packet=new byte[1]; break;//������ Ŭ���̾�Ʈ���� �α��� ��û
		 case Protocol.PT_RES_LOGIN : packet=new byte[21]; break; //�α��νõ�; type:1, id:10, pass:10 = 21
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
