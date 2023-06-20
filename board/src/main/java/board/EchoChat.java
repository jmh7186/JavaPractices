package board;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class EchoChat {
	Session session;

	@OnOpen
	public void open(Session session) {
		System.out.println("Open");
		this.session = session;
	}

	@OnClose
	public void close() {
		System.out.println("Close");
	}

	@OnError
	public void error(Throwable error) {
		System.out.println("Error");
	}

	@OnMessage
	public void message(String message, Session session) {
		System.out.println(message);
		//session.getBasicRemote().sendText(message);
		for (Session s:session.getOpenSessions()) {
			if(s.isOpen()) {
				s.getAsyncRemote().sendText(session.getId()+" : "+message);
			}
		}
	}
}
