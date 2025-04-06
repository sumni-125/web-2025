package teamproject;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateNotice")
public class updateNoticeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String notices_cd = req.getParameter("notices_cd");
		
		Service s =new Service();
		Notice notice = s.selectOneNotice(notices_cd);
		
		req.setAttribute("notice", notice);
		req.getRequestDispatcher("WEB-INF/views/updateNotice.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String title = req.getParameter("title");
		String notices_description = req.getParameter("notices_description");
		String teacher_cd = req.getParameter("teacher_cd");
		String class_cd = req.getParameter("class_cd");
		String notices_cd = req.getParameter("notices_cd");
		String write_date =req.getParameter("write_date");
		
		Notice n = new Notice(notices_cd, title, notices_description, write_date, teacher_cd, class_cd);

		System.out.println(n);
		
		Service s = new Service();
		s.updateNotice(n);

		resp.sendRedirect("/day05Prj/noticeList?teacher_cd="+teacher_cd);
	}
	
}
