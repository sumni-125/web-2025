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


@WebFilter("*.do")
public class Filter3   implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	 
		
		
		//세션  로그인 확인
		// - 로그인되어 있으면  정상적인 흐름
		// -아니면  로그인될 수 있도록 sendRedirect()
						
		HttpServletRequest   request_	 = ( HttpServletRequest)request ;
		HttpServletResponse response_    = (HttpServletResponse)  response;
		
		HttpSession  session  = request_.getSession();		
		String id  = ( String)session.getAttribute("id");
		
		
		System.out.println("hi");
		
		if( id != null) {   //로그인된 경우 원래의 흐름이 요청되게 해 준다 
			
			chain.doFilter(request_, response_);
			
		}else {
			
			// 로그인되지 않으면  로그인이 요청될 수 있도록  redirect 호출함
			
			response_.sendRedirect("/filterPrj_/login");
		}
	 
		
		
		
	}

}
