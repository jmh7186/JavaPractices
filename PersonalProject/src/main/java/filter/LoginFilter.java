package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public LoginFilter() {
		super();
	}

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//세션 확인
		HttpServletRequest hsreq = (HttpServletRequest) request;
		HttpSession session = hsreq.getSession();
		
		if (session.getAttribute("id")==null){
			if(!(hsreq.getRequestURI().contains("/member") || hsreq.getRequestURI().contains("/signup") || hsreq.getRequestURI().contains("/map") || hsreq.getRequestURI().contains("/resource"))) {
				hsreq.setAttribute("mainpage", "/member/login.jsp");
				hsreq.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
				return; 
			}
		}
		
		chain.doFilter(request, response);
	}

}
