package tripMate.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tripMate.dao.UserDAO;
import tripMate.model.User;
import tripMate.service.loginService;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		loginService sevice = new loginService();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		User user = sevice.checkUser(id, pw);
		System.out.println(user);
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect("/TripMate/main");
		} else {
			resp.sendRedirect("/TripMate/login");
		}
	}
}
