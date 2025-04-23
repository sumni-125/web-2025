package tripMate.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

import tripMate.dao.ScheduleDAO;
import tripMate.model.MarkerData;
import tripMate.model.Schedule;
import tripMate.model.TripData;

@WebServlet("/tripSet")
public class tripSetServlet extends HttpServlet {
	ScheduleDAO dao = new ScheduleDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println(req.getParameter("sd_code"));
		if (req.getParameter("sd_code") != null) {
			ArrayList<MarkerData> list = dao.getMarker(req.getParameter("sd_code"));
			Schedule sc = dao.getSchedule(req.getParameter("sd_code"));
			HttpSession session = req.getSession();
			session.setAttribute("savedMarkers", list);
			session.setAttribute("sc", sc);
			System.out.println(list);
			System.out.println(sc);
		} else {

			//HttpSession session = req.getSession();
			//dao.insertSchedule((Schedule) session.getAttribute("sc"));
			//ArrayList<MarkerData> list = (ArrayList<MarkerData>) session.getAttribute("savedMarkers");
			//for (MarkerData m : list) {
			//	dao.insertMarker(m);
			//}

		}

		req.getRequestDispatcher("WEB-INF/views/tripSet.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// POST 요청 시 클라이언트에서 보낸 JSON 데이터 읽기
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		try (BufferedReader reader = req.getReader()) {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
			}
		}

		// JSON 데이터를 문자열로 받음
		String jsonData = stringBuilder.toString();

		// Gson 라이브러리로 JSON 데이터를 Java 객체로 변환
		Gson gson = new Gson();
		TripData tripData = gson.fromJson(jsonData, TripData.class);

		// 받은 데이터 출력 (디버그용)
		System.out.println("일정 제목: " + tripData.getTitle());
		for (MarkerData marker : tripData.getMarkers()) {
			System.out
					.println(marker.getDayS() + ", 주소: " + marker.getAddress() + ", 부가 설명: " + marker.getDescription());
		}
		HttpSession session = req.getSession();
		Schedule presc = (Schedule) session.getAttribute("sc");
		Schedule sc = new Schedule(presc.getSd_code(), tripData.getTitle(), presc.getStart_date(), presc.getEnd_date(),
				presc.getPlace_name());
		System.out.println(sc);
		dao.updateSchedule(sc);
		ArrayList<MarkerData> list = (ArrayList<MarkerData>) tripData.getMarkers();
		System.out.println("마커마커마커");
		for (MarkerData md : list) {
			System.out.println(md);
			dao.updateMarker(md);
		}
		// 처리 후 응답
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("{\"status\":\"success\"}");
	}
}
