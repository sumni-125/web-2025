package day07Prac.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 로그인 화면 응답

		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		System.out.println(id + pw);

		// 로그인성공 여부 = 서비스, DAO 필요함
		// 간단하게 로직을 처리 >> id, pw 같으면 회원으로 인증

		boolean result;
		if (id.equals(pw)) {
			result = true;
		} else {
			result = false;
		}

		if (result == true) {
			// 로그인 성공 정보를 세션에 저장하기

		 	// 1. 세션 저장소 얻어오기
			// 2. 저장하기

			HttpSession session = req.getSession();
			session.setAttribute("loginId", id);

			// 메인퓨ㅔ이지 요청할 수 있도록 redirect하기
			resp.sendRedirect("/day07Prac/main");

		} else {
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}

	}

}
