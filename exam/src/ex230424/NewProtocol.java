package ex230424;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class NewProtocol implements Serializable{
	int type;
	byte[] packet;
	
	public NewProtocol() {
		packet=new byte[100];
	}
	
	public NewProtocol(int type, byte[] packet) {
		this.type = type;
		this.packet=packet;
	}
	public NewProtocol(int totallen) {
		packet=new byte[totallen];
	}

	@Override
	public String toString() {
		return "Protocol [type=" + type + ", packet=" + packet + "]";
	}
	
	public String getId() {
		//packet의 0번째부터 10자리가 id임.
		byte[] imsi=new byte[1024];
		System.arraycopy(packet, 0, imsi, 0, 10);
		return new String(imsi).trim();
	}
	
	public String getPassword() {
		//packet의 10번째부터 10자리가 password임.
		byte[] imsi=new byte[1024];
		System.arraycopy(packet, 10, imsi, 0, 10);
		return new String(imsi).trim();
	}

	public int getLenth() {
		byte[] buf=new byte[4];
		System.arraycopy(packet, 20, buf, 0, buf.length);
		//inte바이트 배열을 정수로 변경하시오.
		int length=ByteBuffer.wrap(buf).getInt();
		return length;
	}
	
}
