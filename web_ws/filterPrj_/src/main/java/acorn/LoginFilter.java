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

//ServletRequest, ServletResponse	// HttpServletRequest, HttpServletResponse
//업캐스팅 된 상태로 받는다

@WebFilter("*.acorn")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		// 다운캐스팅하기
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");

		if (id != null) { // 로그인 되어있는 경우 -> 원래 흐름대로 실행될 수 있도록 하기
			// chain.doFilter(request, response); =>호출 해야 원래 흐름 bookServlet이 실행됨

			// 서블릿이 실행되기 전에 수행할 코드
			chain.doFilter(request, response);
			// 서블릿이 실행된 후 응답되기 전에 수행할 코드

		} else {
			// 로그인 서비스가 요청될 수 있도록 redirect 하기
			String path = req.getContextPath();
			resp.sendRedirect(path + "/login");

		}

		// 세션의 로그인정보값 확인하기

		// 로그인되어있는 경우

		// 아닌경우 => 로그인 요청되게 redirect

	}

}
