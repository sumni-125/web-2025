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
		String parent_id = req.getParameter("parent_id");

		Service service = new Service();

		if (student_cd != null) {
			Student s = service.selectOne(student_cd);
			if (s == null) {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND, "학생 정보를 찾을 수 없습니다.");
				return;
			}

			req.setAttribute("s", s);
			
			req.getRequestDispatcher("WEB-INF/views/StudentEdit.jsp").forward(req, resp);
			
		} else if (parent_id != null) {
			Parents p = service.selectOne1(parent_id);
			if (p == null) {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND, "학부모 정보를 찾을 수 없습니다.");
				return;
			}

			req.setAttribute("p", p);
			
			req.getRequestDispatcher("WEB-INF/views/updateOne.jsp").forward(req, resp);
		}

		
	}
}
