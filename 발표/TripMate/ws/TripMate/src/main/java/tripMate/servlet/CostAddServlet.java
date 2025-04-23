package tripMate.servlet;

import tripMate.model.Cost;
import tripMate.model.PersonalCost;
import tripMate.model.Schedule;
import tripMate.service.CostAddService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@WebServlet("/costAdd")
public class CostAddServlet extends HttpServlet {
	private CostAddService service = new CostAddService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sd_code = req.getParameter("sd_code");
		if (sd_code == null || sd_code.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "sd_code가 필요합니다.");
			return;
		}

		Schedule schedule = service.getSchedule(sd_code);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		LocalDate start = LocalDate.parse(schedule.getStart_date(), fmt);
		LocalDate end = LocalDate.parse(schedule.getEnd_date(), fmt);
		int days = (int) (end.toEpochDay() - start.toEpochDay()) + 1;
		String[] tripDates = new String[days];
		for (int i = 0; i < days; i++) {
			tripDates[i] = start.plusDays(i).format(fmt);
		}

		ArrayList<String> categories = service.getAllCategories();
		ArrayList<String> paymentTypes = service.getAllPaymentTypes();
		ArrayList<String> paymentMethods = service.getAllPaymentMethods();
		ArrayList<String> names = service.getParticipantNames(sd_code);

		req.setAttribute("sd_code", sd_code);
		req.setAttribute("tripName", schedule.getName());
		req.setAttribute("tripPeriod", schedule.getStart_date() + " ~ " + schedule.getEnd_date());
		req.setAttribute("tripDates", tripDates);
		req.setAttribute("category", categories);
		req.setAttribute("paymentType", paymentTypes);
		req.setAttribute("paymentMethod", paymentMethods);
		req.setAttribute("names", names);
		req.getRequestDispatcher("/WEB-INF/views/costAdd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// 1) 파라미터 수집
		String sd_code = req.getParameter("sd_code");
		String tripDate = req.getParameter("tripDate");
		String category = req.getParameter("category");
		String location = req.getParameter("location");
		int amount = Integer.parseInt(req.getParameter("amount"));
		String paymentType = req.getParameter("paymentType");
		String payerNick = req.getParameter("payer");
		String paymentMethod = req.getParameter("paymentMethod");

		// 1-1) 닉네임으로 user_code 조회 및 로깅
		String payerCode = service.getUserCodeByNickname(payerNick);
		System.out.println("[CostAddServlet] payerNick='" + payerNick + "', payerCode='" + payerCode + "'");

		// 2) Cost 객체 생성
		Cost cost = new Cost();
		cost.setTripCode(sd_code);
		cost.setTripDate(tripDate);
		cost.setCategory(category);
		cost.setLocation(location);
		cost.setAmount(amount);
		cost.setPaymentType(paymentType);
		cost.setPaymentMethod(paymentMethod);
		cost.setPayerCode(payerCode); // user_code 사용

		// 3) 개인결제 처리
		if ("개인결제".equals(paymentMethod)) {
			service.addCost(cost);
			System.out.println("[CostAddServlet] 저장된 costId=" + cost.getCostId());

			PersonalCost pc = new PersonalCost();
			pc.setCostId(cost.getCostId());
			pc.setUserCode(payerCode);
			pc.setPersonCost(amount);
			pc.setStatus("정산완료");
			pc.setPayer(payerNick);

			service.addPersonalCost(pc);
			System.out.println("[CostAddServlet] 저장된 personalCostId=" + pc.getPersonalCostId());

			resp.sendRedirect(req.getContextPath() + "/cost?sd_code=" + sd_code);
			return;
		}

		// 4) 분할/분배 처리
		HttpSession session = req.getSession();
		session.setAttribute("pendingCost", cost);
		session.setAttribute("names", service.getParticipantNames(sd_code));
		if ("한번에결제".equals(paymentMethod)) {
			resp.sendRedirect(req.getContextPath() + "/costSplit?sd_code=" + sd_code);
		} else {
			resp.sendRedirect(req.getContextPath() + "/costDivide?sd_code=" + sd_code);
		}
	}
}
