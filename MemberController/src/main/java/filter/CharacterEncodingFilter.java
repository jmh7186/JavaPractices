package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

//@WebFilter(filterName = "CharacterEncodingFilter", urlPatterns = { "/*" })
public class CharacterEncodingFilter extends HttpFilter implements Filter {
       
    public CharacterEncodingFilter() {
    	System.out.println("genarate filter");
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("do filter");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response); //servlet의 service함수를 실행하도록 넘기는 함수
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init filter");
	}

}
