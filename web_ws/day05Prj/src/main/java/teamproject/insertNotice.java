package teamproject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertNotice")
public class insertNotice extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String teacher_cd = req.getParameter("teacher_cd");
		
		req.setAttribute("teacher_cd", teacher_cd);
		req.getRequestDispatcher("WEB-INF/views/insertNotice.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String title = req.getParameter("title");
		String notices_description = req.getParameter("notices_description");
		String teacher_cd = req.getParameter("teacher_cd");
		String class_cd = req.getParameter("class_cd");

		LocalDateTime now = LocalDateTime.now();
		// 원하는 형식 지정
		DateTimeFormatter cdformatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyyMMdd");

		// 날짜와 시간을 형식에 맞게 문자열로 변환
		String notices_cd = now.format(cdformatter);
		String write_date = now.format(dateformatter);

		Notice n = new Notice(notices_cd, title, notices_description, write_date, teacher_cd, class_cd);

		System.out.println(n);
		
		Service s = new Service();
		s.insertNotice(n);

		resp.sendRedirect("/day05Prj/noticeList?teacher_cd="+teacher_cd);
	}

}
