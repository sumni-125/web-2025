package teamproject;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentList")
public class StudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Service s = new Service();
		ArrayList<Student> list = s.getStudentList();

		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/Student.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");

		Service s = new Service();

		if ("delete".equals(action)) {
			String student_cd = req.getParameter("student_cd");
			s.deleteStudent(student_cd);
			resp.sendRedirect("studentList");
			return;
		}

		String student_cd = req.getParameter("student_cd");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String class_cd = req.getParameter("class_cd");
		String class_no = req.getParameter("class_no");
		String grade = req.getParameter("grade");
		String name = req.getParameter("name");

		Student student = new Student(student_cd, id, pw, class_cd, class_no, grade, name);
		s.registerStudent(student);

		ArrayList<Student> list = s.getStudentList();
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/Student.jsp").forward(req, resp);
	}

}
