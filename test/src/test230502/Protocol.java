package test230502;

public class Protocol {

	public static final int PT_LOGOUT = 0; // 종료
	public static final int PT_LOGIN_REQ = 1; // 로그인 시도
	public static final int PT_LOGIN_RES = 2; // 로그인
	public static final int PT_RESULT_LOGIN = 3; // 로그인인증결과
	public static final int PT_LOGIN_SUCCESS = 31; // 로그인 성공
	public static final int PT_LOGIN_FAIL = 30; // 로그인 실패
	public static final int PT_CHAT = 4;		//챗팅메시지전송

	private int protocolType;

	private byte[] packet;

	public Protocol() {
		this(-1);
	}

	public Protocol(int protocolType) {

		this.protocolType = protocolType;
		getPacket(protocolType);
	}

	public byte[] getPacket(int protocolType) {

		if (packet == null) {

			switch (protocolType) {

			case PT_LOGIN_REQ:
				packet = new byte[1];
				break;
			case PT_LOGIN_RES:
				packet = new byte[21];
				break;
			case PT_RESULT_LOGIN:
				packet = new byte[2];
				break;
			case PT_LOGOUT:
				packet = new byte[1];
				break;
			case PT_CHAT:
				packet = new byte[1024];
				break;
			default: 
				packet = new byte[1024];
				break;
			}
		}

		packet[0] = (byte) protocolType;
		return packet;
	}


	public void setProtocolType(int protocolType) {
		this.protocolType = protocolType;
	}

	public int getProtocolType() {
		return getPacket()[0];
	}

	public byte[] getPacket() {
		return packet;
	}


	public String getId() {
		return new String(packet, 1, 10).trim();
	}

	public void setId(String id) {
		System.arraycopy(id.trim().getBytes(), 0, packet, 1, id.trim().getBytes().length);
	}

	public String getPassword() {
		return new String(packet, 11, 21).trim();
	}

	public void setPassword(String password) {
		System.arraycopy(password.trim().getBytes(), 0, packet, 11, password.trim().getBytes().length);
	}

}
