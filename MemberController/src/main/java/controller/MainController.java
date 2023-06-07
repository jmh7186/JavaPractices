package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainController() {
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();

		String asidepage = "home/aside.jsp";
		String mainpage = "home/main.jsp";

		if (uri.equals("/company")) {
			asidepage = "aside/company.jsp";
		} else if (uri.equals("/info")) {
			asidepage = "aside/info.jsp";
		} else if (uri.equals("/phonebook")) {
			mainpage="main/list.jsp";
		} else if (uri.equals("/gallary")) {
			asidepage = "aside/gallary.jsp";
		} else if (uri.equals("/board")) {
			asidepage = "aside/board.jsp";
		} else if (uri.equals("/login")) {
			mainpage="member/login.jsp";
		} else if (uri.equals("/login/loginProc")) {
			mainpage="member/loginProc.jsp";
		} else if (uri.equals("/logout")) {
			mainpage="member/logout.jsp";
		} else if (uri.equals("/signup/contract")) {
			mainpage="member/contract.jsp";
		} else if (uri.equals("/signup")) {
			mainpage="member/signup.jsp";
		} else if (uri.equals("/signup/signupProc")) {
			mainpage="member/signupProc.jsp";
		}
	

		request.setAttribute("mainpage", mainpage);
		request.setAttribute("asidepage", asidepage);
		
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
