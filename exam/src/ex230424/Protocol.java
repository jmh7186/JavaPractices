package ex230424;

import java.io.Serializable;

public class Protocol implements Serializable{
	private int type;
	private String msg;
	public Protocol(int type, String msg) {
		this.type = type;
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Protocol [type=" + type + ", msg=" + msg + "]";
	}
	
	
}
