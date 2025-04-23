package tripMate.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tripMate.dao.ScheduleDAO;
import tripMate.dao.UserDAO;
import tripMate.model.Schedule;
import tripMate.model.User;

@WebServlet("/myTrip")
public class myTripServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		ScheduleDAO dao = new ScheduleDAO();
		ArrayList<Schedule> schedule = dao.getScheduleList(user);

		req.setAttribute("schedule", schedule);

		req.getRequestDispatcher("WEB-INF/views/tripList.jsp").forward(req, resp);

	}
}
