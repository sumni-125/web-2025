package teamproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateForm")
public class UpdateFormServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String student_cd = req.getParameter("student_cd");

		if (student_cd == null || student_cd.trim().isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "학생 코드가 전달되지 않았습니다.");
			return;
		}

		Service service = new Service();
		Student s = service.selectOne(student_cd);

		if (s == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "학생 정보를 찾을 수 없습니다.");
			return;
		}

		req.setAttribute("s", s);
		req.getRequestDispatcher("WEB-INF/views/StudentEdit.jsp").forward(req, resp);
	}
}
