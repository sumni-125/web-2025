package teamproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateStudent")
public class updateStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String old_cd = req.getParameter("old_cd"); // 원래 학번
		String student_cd = req.getParameter("student_cd"); // 수정된 학번
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String class_cd = req.getParameter("class_cd");
		String class_no = req.getParameter("class_no");
		String grade = req.getParameter("grade");
		String name = req.getParameter("name");

		Student s = new Student(student_cd, id, pw, class_cd, class_no, grade, name);
		Service service = new Service();
		service.updateStudentWithOriginalCd(s, old_cd); // 새 메서드 호출

		resp.sendRedirect("studentList");
	}

}
