package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.HRD_MemberVO;
import member.HrdDAO;

@WebServlet(name = "MainController", urlPatterns = { "/" })
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
    	
    }
    
    public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName(config.getInitParameter("driver"));
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("Main Controller : "+uri);
		String page = "index.jsp";
		if(uri.equals("/list")) {
			request.setAttribute("member", new HrdDAO().findAll());
			page="list.jsp";
		}else if(uri.equals("/moneylist")) {
			request.setAttribute("sales", new HrdDAO().findSales());
			page="/moneylist.jsp";
		}else if(uri.equals("/signup")) {
			request.setAttribute("count", new HrdDAO().memberCount());
			page="/signup.jsp";
		}else if(uri.equals("/signupProc")) {
			HRD_MemberVO m = new HRD_MemberVO(
											request.getParameter("idx"),
											request.getParameter("name"),
											request.getParameter("hp"),
											request.getParameter("adr"),
											request.getParameter("date"),
											request.getParameter("rank"),
											request.getParameter("city")
											);
			request.setAttribute("result", new HrdDAO().insert(m));
			page="/signupProc.jsp";
		}else if(uri.equals("/update")) {
			request.setAttribute("member", new HrdDAO().findOne(request.getParameter("custno")));
			page="/update.jsp";
		}else if(uri.equals("/updateProc")) {
			HRD_MemberVO m = new HRD_MemberVO(
											request.getParameter("idx"),
											request.getParameter("name"),
											request.getParameter("hp"),
											request.getParameter("adr"),
											request.getParameter("date"),
											request.getParameter("rank"),
											request.getParameter("city")
											);
			request.setAttribute("result", new HrdDAO().update(m));
			page="/updateProc.jsp";
		}
		
		request.getRequestDispatcher("/WEB-INF/"+page).forward(request, response);
	}

}
