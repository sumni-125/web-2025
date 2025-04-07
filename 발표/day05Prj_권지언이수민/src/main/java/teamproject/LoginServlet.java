package teamproject;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String role = req.getParameter("role");

		boolean success = false;

		if (role.equals("teacher")) {
			success = new TeacherDAO().login(id, pw);
		} else if (role.equals("student")) {
			success = new StudentDAO().login(id, pw);
		} else if (role.equals("parents")) {
			success = new ParentsDAO().login(id, pw);
		}

		if (success) {
			session.setAttribute("id", id);
			session.setAttribute("role", role);

			switch (role) {
			case "teacher":
				Teacher teacher = new TeacherDAO().getTeacherById(id);
				session.setAttribute("teacher", teacher);
				req.getRequestDispatcher("WEB-INF/views/teacherDashboard.jsp").forward(req, resp);
				break;
			case "student":
				Student student = new StudentDAO().getStudentById(id);
				session.setAttribute("student", student);
				req.getRequestDispatcher("WEB-INF/views/studentDashboard.jsp").forward(req, resp);
				break;
			case "parents":
				Parents parents = new ParentsDAO().getParentsById(id);
				session.setAttribute("parents", parents);
				req.getRequestDispatcher("WEB-INF/views/parentsDashboard.jsp").forward(req, resp);
				break;
			}
		} else {
			resp.sendRedirect("Login?error=1");
		}
	}
}
