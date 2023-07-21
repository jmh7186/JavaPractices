//package controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import service.BoardService;
//import service.MemberService;
//import service.PhonebookService;
//import vo.MemberVO;
//
////@WebServlet("/")
//public class MainController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MemberService mbservice = new MemberService();
//		PhonebookService pbservice = new PhonebookService();
//		BoardService bdservice = new BoardService();
//		System.out.println("service called");
//		String page = "NotFound.jsp";
//		//////////////////////////////////회원(로그인,로그아웃,정보수정/조회/삭제)//////////////////////////////////////////
//		if(request.getRequestURI().equals("/member/login")) {
//			page = "/index.jsp";
//			request.setAttribute("mainpage", "/member/login.jsp");
//		}else if(request.getRequestURI().equals("/member/loginProc")) {
//			page = "/index.jsp";
//			request.setAttribute("mainpage", "/member/loginProc.jsp");
//			String id = request.getParameter("id");
//			String pwd = request.getParameter("pwd");
////			request.setAttribute("result", mbservice.login(id, pwd));
//			request.setAttribute("id", id);
//		}else if(request.getRequestURI().equals("/logoutProc")) {
//			request.getSession().invalidate();
//			page = "index.jsp";
//			request.setAttribute("mainpage", "home/main.jsp");
//		}else if(request.getRequestURI().equals("/member/view")) {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "member/viewmember.jsp");
//			String id = request.getParameter("id");
////			request.setAttribute("member", mbservice.findOne(id));
//		}else if(request.getRequestURI().equals("/member/updateProc")) {
//			page = "member/updateProc.jsp";
//			MemberVO m = new MemberVO();
//			m.setId(request.getParameter("id"));
//			m.setPwd(request.getParameter("pwd"));
//			m.setHp(request.getParameter("hp"));
//			m.setAdr(request.getParameter("adr"));
//			int result = mbservice.updateById(m);
//			request.setAttribute("result", result);
//		}else if(request.getRequestURI().equals("/member/deleteProc")) {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "member/deleteProc.jsp");
//			String id = request.getParameter("id");
//			request.setAttribute("result", mbservice.deleteById(id));
//			request.getSession().invalidate();
//		//////////////////////////////////회원가입//////////////////////////////////////////
//		}else if(request.getRequestURI().equals("/signup/contract")) {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "member/contract.jsp");
//			
//		}else if(request.getRequestURI().equals("/signup")) {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "member/signup.jsp");
//			
//		}else if(request.getRequestURI().equals("/signup/signupProc")) {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "member/signupProc.jsp");
//			String id = request.getParameter("id");
//			String pwd = request.getParameter("pwd");
//			String hp = request.getParameter("hp");
//			String adr = null;
//			if(request.getParameter(adr)!=null) {
//				adr = request.getParameter(adr);
//			}
//			MemberVO m = new MemberVO();
//			m.setId(id);
//			m.setPwd(pwd);
//			m.setHp(hp);
//			m.setAdr(adr);
//			request.setAttribute("result", mbservice.insert(m));
//		//////////////////////////////////전화번호부//////////////////////////////////////////
//			
//		}else if(request.getRequestURI().equals("/phonebook/pagelist")) {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "phonebook/pageList.jsp");
//			int currpage = 1;
//			if (request.getParameter("page")!=null) {
//				currpage = Integer.valueOf(request.getParameter("page"));
//			}
//			request.setAttribute("pagelist", pbservice.pageList(currpage));
//			
//		}else if(request.getRequestURI().equals("/phonebook/view")) {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "phonebook/view.jsp");
//			String idx = request.getParameter("idx");
//			request.setAttribute("p", pbservice.findOne(idx));
//			
//		}else if(request.getRequestURI().equals("/phonebook/update")) {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "phonebook/view.jsp");
//			String idx = request.getParameter("idx");
//			request.setAttribute("p", pbservice.findOne(idx));
//			
//		}else if(request.getRequestURI().equals("/phonebook/delete")) {
//			String idx = request.getParameter("idx");
//			pbservice.delete(idx);
//			response.sendRedirect("/phonebook/pagelist");
//			return;
//		//////////////////////////////////게시판//////////////////////////////////////////
//		}else if(request.getRequestURI().equals("/board/pagelist")) {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "board/pageList.jsp");
//			int currpage = 1;
//			if (request.getParameter("page")!=null) {
//				currpage = Integer.valueOf(request.getParameter("page"));
//			}
//			request.setAttribute("pagelist", bdservice.pageList(currpage,10));
//		//////////////////////////////////맵//////////////////////////////////////////
//		}else if(request.getRequestURI().equals("/map")) {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "map/map.jsp");
//		//////////////////////////////////채팅//////////////////////////////////////////
//		} else if (request.getRequestURI().equals("/chat")) {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "chat/chat.jsp");
//
//		}else {
//			page = "index.jsp";
//			request.setAttribute("mainpage", "home/main.jsp");
//		}
//		request.getRequestDispatcher("/WEB-INF/"+page).forward(request, response);
//	}
//
//}
