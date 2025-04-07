package teamproject;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/noticeList")
public class NoticeListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String teacher_cd = req.getParameter("teacher_cd");
		
		Service s = new Service();
		ArrayList<Notice> list =  s.selectNotice(teacher_cd);
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("WEB-INF/views/myNoticeList.jsp").forward(req, resp);
		
		
		
	}
	
	 
}
