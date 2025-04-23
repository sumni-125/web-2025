package tripMate.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tripMate.model.Schedule;

@WebServlet("/tripCal")
public class tripCalServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("이게 되네");
		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("selectedStart"));
		req.getRequestDispatcher("WEB-INF/views/cal.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");

		System.out.println("POST 받은 시작 날짜: " + start);
		System.out.println("POST 받은 종료 날짜: " + end);

		// 예: 세션에 저장
		HttpSession session = req.getSession();
		session.setAttribute("selectedStart", start);
		session.setAttribute("selectedEnd", end);
		session.setAttribute("sc", new Schedule(null, null, start, end, null));
		resp.sendRedirect(req.getContextPath() + "/tripMap");
	}
}
