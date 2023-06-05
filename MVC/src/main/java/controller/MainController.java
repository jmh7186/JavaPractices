package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainController() {

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
//    	resp.setContentType("text/html; charset=UTF-8");

//		PrintWriter out = resp.getWriter();
//		out.println("Hello, Controller!");
//		// path 설정 경로
//		out.println(req.getContextPath());
//		// 전체 경로
//		out.println(req.getRequestURL());
//		// path + 경로
//		out.println(req.getRequestURI());
//		// ? 뒤의 문자열만 출력 (& 포함)
//		System.out.println(req.getQueryString());

//    	req.getRequestURI() 주소를 분리하여 Controller 실행
//    	System.out.println(req.getRequestURL());
		String uri = req.getRequestURI();
		String[] uris = uri.split("/");
//		for (String temp : uris) {
//			System.out.println(temp);
//		}
		
		if(req.getQueryString() != null) {
			String[] para1 = req.getQueryString().split("&"); //getParameter() 사용하는 것이 편함
			String[] para2 = para1[0].split("=");
			int su1 = Integer.parseInt(para2[1]);
			para2 = para1[1].split("=");
			int su2 = Integer.parseInt(para2[1]);
//			System.out.println(su1 + "/" + su2);
			req.setAttribute("su1", su1);
			req.setAttribute("su2", su2);
		}

		String page = "index.jsp";
		switch (uri) {
		case "/add": page = "add.jsp"; break;
		case "/sub": page = "sub.jsp"; break;
		case "/mux": page = "mux.jsp"; break;
		case "/div": page = "div.jsp"; break;
		default: page = "index.jsp"; break;
		}

//    	resp.sendRedirect("/WEB-INF/index.jsp"); //web주소로 리다이렉트(내부접근불가)
		req.getRequestDispatcher("/WEB-INF/" + page).forward(req, resp); // WEB-INF 내부 접근 가능
	}
}
