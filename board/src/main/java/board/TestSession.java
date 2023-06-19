package board;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/test")
public class TestSession {
	static int index = 0;
	static Session[] sessions = new Session[100];

	@OnOpen
	public void open(Session session) {
		sessions[index++] = session;
		System.out.println("현재 접속자 " + index + "명");
		System.out.println(session.getId());
	}

	@OnClose
	public void close() {
		
	}

	@OnError
	public void error(Throwable error) {

	}

	@OnMessage
	public void message(String message) {
		try {
			for (int i = 0; i < index; i++) {
				sessions[i].getBasicRemote().sendText(message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
