package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class PhonebookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PhonebookController() {

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();
		
		
		String page = "list.jsp";
		switch (uri) {
		case "/insert": page = "insert.jsp"; break;
		case "/delete": page = "delete.jsp"; break;
		case "/update": page = "update.jsp"; break;
		case "/view": page = "view.jsp"; break;
		case "/search": page = "searchList.jsp"; break;
		default: page = "list.jsp"; break;
		}

		req.getRequestDispatcher("/phonebook/" + page).forward(req, resp);
	}
}
