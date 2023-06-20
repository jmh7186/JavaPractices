package board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class User1 {
	static String id = "admin1";
	static String password = "1234";
}

class User2 {
	static String id = "admin2";
	static String password = "1234";
}

class User3 {
	static String id = "admin3";
	static String password = "1234";
}

class Sessionlis {
	String id;
	Session session;
	public Sessionlis(String id, Session session) {
		this.id=id;
		this.session=session;
	}
	public Session getSession () {
		return session;
	}
	public String getId () {
		return id;
	}
}
@ServerEndpoint("/chatuser")
public class WebSocketUser {
	static Set<Session> sessions = new HashSet<Session>();
	String id;
	String password;
	static List<Sessionlis> sessionlis = new ArrayList<Sessionlis>();

	@OnOpen
	public void open(Session session) {
		System.out.println("Open");
		sessions.add(session);
	}

	@OnClose
	public void close(Session session) {
		System.out.println("Close");
		sessions.remove(session);
		sessionlis.remove(session);
	}

	@OnError
	public void error(Throwable error) {
		System.out.println("Error");
	}

	@OnMessage
	public void message(String message, Session session) {
		try {
			JSONObject jobj = (JSONObject) new JSONParser().parse(message);
			if (jobj.get("kind").equals("login")) {
				if (jobj.get("id").equals(User1.id) && jobj.get("password").equals(User1.password)) {
					sessionlis.add(new Sessionlis((String)jobj.get("id"),session));
					jobj.put("result", "success");
				} else if (jobj.get("id").equals(User2.id) && jobj.get("password").equals(User2.password)) {
					sessionlis.add(new Sessionlis((String)jobj.get("id"),session));
					jobj.put("result", "success");
				} else if (jobj.get("id").equals(User3.id) && jobj.get("password").equals(User3.password)) {
					sessionlis.add(new Sessionlis((String)jobj.get("id"),session));
					jobj.put("result", "success");
				} else {
					jobj.remove("id");
					jobj.put("result", "fail");
				}
				jobj.remove("password");
				session.getAsyncRemote().sendText(jobj.toJSONString());
			}else if(jobj.get("kind").equals("sel")) {
				for(Sessionlis s : sessionlis) {
					if(s.getId().equals(jobj.get("selid"))) {
						s.getSession().getAsyncRemote().sendText(jobj.toJSONString());
					}
				}
			}else {
				for(Session s:sessions) {
					s.getAsyncRemote().sendText(jobj.toJSONString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
