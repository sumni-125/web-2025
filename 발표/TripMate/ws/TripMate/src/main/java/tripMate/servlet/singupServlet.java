package tripMate.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripMate.dao.UserDAO;

@WebServlet("/signup")
public class singupServlet extends HttpServlet {
	UserDAO dao = new UserDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/signup.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String pwcheck = req.getParameter("pwcheck");
		String nickname = req.getParameter("nickname");

		if (pw.equals(pwcheck)) {
			dao.insertUser(id, pw, nickname);
			resp.sendRedirect("/TripMate/login");
		} else {
			resp.sendRedirect("/TripMate/signup");
		}

	}
}
