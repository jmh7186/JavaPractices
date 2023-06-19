package board;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
public class WebSocket {
	Session session;
	Scanner sc;
	int vote1 = 0;
	int vote2 = 0;
	int vote3 = 0;
	int vote4 = 0;
	int[] arr = {0,0,0,0};

	@OnOpen
	public void open(Session session) {
		System.out.println("Open");
		this.session = session;
		try {
//			String send = "{\"vote1\":\"" + vote1 + "\",\"vote2\":\"" + vote2 + "\",\"vote3\":\"" + vote3 + "\",\"vote4\":\"" + vote4 + "\"}";
			session.getBasicRemote().sendText(Arrays.toString(arr));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@OnClose
	public void close() {
		System.out.println("Close");
		try {
//			sc.close();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnError
	public void error(Throwable error) {
		System.out.println("Error");
	}

	@OnMessage
	public void message(String message) {
		System.out.println(message);
		try {
			if(message.equals("1")) {
				arr[0]++;
			}else if(message.equals("2")) {
				arr[1]++;
			}else if(message.equals("3")) {
				arr[2]++;
			}else if(message.equals("4")) {
				arr[3]++;
			}
//			String send = "{\"vote1\":\"" + vote1 + "\",\"vote2\":\"" + vote2 + "\",\"vote3\":\"" + vote3 + "\",\"vote4\":\"" + vote4 + "\"}";
			session.getBasicRemote().sendText(Arrays.toString(arr));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
