package chat;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.util.JSONPObject;

@ServerEndpoint("/chat")
public class chatservice {
	static Set<Session> sessions = new HashSet<Session>();

	@OnOpen
	public void open(Session session) {
		System.out.println("Open");
		sessions.add(session);
		System.out.println("접속자 수 : " + sessions.size());
		session.getAsyncRemote().sendText("현재 접속자 수 : " + sessions.size());
	}

	@OnClose
	public void close(Session session) {
		System.out.println("Close");
		sessions.remove(session);
		System.out.println("접속자 수 : " + sessions.size());
	}

	@OnError
	public void error(Throwable error) {
		System.out.println("Error");
	}

	@OnMessage
	public void message(String message, Session session) {
		try {
			if(message!=null) {
				JSONParser parse = new JSONParser();
				Object obj = parse.parse(message);
				JSONObject json = (JSONObject) obj;
				System.out.println(json.get("id"));
				System.out.println(json.get("msg"));
			}
			for (Session s : sessions) {
				s.getAsyncRemote().sendText(message);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
