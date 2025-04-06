package teamproject;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/parentsList")
public class ParentsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service s = new Service();
		ArrayList<Parents> list = s.getParentsList();

		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/Parents.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");

		Service s = new Service();

		if ("delete".equals(action)) {
			String parent_id = req.getParameter("parent_id");
			s.deleteParents(parent_id);
			resp.sendRedirect("parentsList");
			return;
		}

		String parent_id = req.getParameter("parent_id");
		String student_cd = req.getParameter("student_cd");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String tel = req.getParameter("tel");

		Parents parents = new Parents(parent_id, student_cd, id, pw, tel);
		s.registerParents(parents);
		
		ArrayList<Parents> list = s.getParentsList();
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/Parents.jsp").forward(req, resp);
	}
}
