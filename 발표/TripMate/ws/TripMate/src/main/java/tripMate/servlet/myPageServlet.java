package tripMate.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripMate.model.User;
import tripMate.service.userService;

@WebServlet("/myPage")
public class myPageServlet extends HttpServlet {
	userService service = new userService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("WEB-INF/views/myPage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String) req.getParameter("id");
		String pw = (String) req.getParameter("pw");
		String nick = (String) req.getParameter("nick");
		service.updateUserData(new User(id, pw, nick));
	}
}
