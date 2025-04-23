package tripMate.servlet;

import tripMate.model.Cost;
import tripMate.model.Schedule;
import tripMate.service.CostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

@WebServlet("/cost")
public class CostServlet extends HttpServlet {
	private CostService service = new CostService();

	// GET 요청: 비용 목록 표시
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sdCode = req.getParameter("sd_code");
		if (sdCode == null || sdCode.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "sd_code가 필요합니다.");
			return;
		}

		// 1) 일정 조회
		Schedule schedule = service.getSchedule(sdCode);

		// 2) 날짜 배열 생성
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		LocalDate start = LocalDate.parse(schedule.getStart_date(), fmt);
		LocalDate end = LocalDate.parse(schedule.getEnd_date(), fmt);
		int days = (int) (end.toEpochDay() - start.toEpochDay()) + 1;
		String[] tripDates = new String[days];
		for (int i = 0; i < days; i++) {
			tripDates[i] = start.plusDays(i).format(fmt);
		}
		
		Arrays.sort(tripDates);

		// 3) 비용 및 참여자 목록 조회
		ArrayList<Cost> list = service.getCostsByTrip(sdCode);
		ArrayList<String> names = service.getParticipantNames(sdCode);

		// 4) JSP에 속성 전달
		req.setAttribute("sd_code", sdCode);
		req.setAttribute("tripName", schedule.getName());
		req.setAttribute("tripPeriod", schedule.getStart_date() + " ~ " + schedule.getEnd_date());
		req.setAttribute("tripDates", tripDates);
		req.setAttribute("names", names);
		req.setAttribute("list", list);

		// 5) cost.jsp 포워딩
		req.getRequestDispatcher("/WEB-INF/views/cost.jsp").forward(req, resp);
	}
}
