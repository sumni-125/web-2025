package teamproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteNotice")
public class DeleteNotice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String notices_cd = req.getParameter("notices_cd");

		Service s = new Service();

		Notice n=s.selectOneNotice(notices_cd);
		s.deleteNotice(notices_cd);
		
		resp.sendRedirect("/day05Prj/noticeList?teacher_cd="+n.getTeacher_cd());

	}
	
}
