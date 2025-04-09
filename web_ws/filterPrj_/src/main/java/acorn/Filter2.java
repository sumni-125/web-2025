package acorn;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("*.do")
public class Filter2 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { 
		 
		System.out.println(" filter 2");
		//  
		HttpServletRequest h_request=    (HttpServletRequest) request;
		HttpServletResponse h_response  = (HttpServletResponse) response ;
		HttpSession   session  = h_request.getSession();
		
		if( session.getAttribute("id") != null ) {
			//요청한 서블릿으로 넘어감			
			//long start = System.currentTimeMillis();
			//System.out.println("before");
			
			chain.doFilter(request, response);
			
			//System.out.println("after");
			//long end = System.currentTimeMillis();
			
		//System.out.println("걸린시간" + (end-start));
			 
		}else {
			String path = h_request.getContextPath();   // 프로젝트이름 얻어오기
			h_response.sendRedirect(path +"/login");			
		}
		
		
		
	}

}
