package tripMate.servlet;

import tripMate.model.Cost;
import tripMate.model.PersonalCost;
import tripMate.service.CostAddService;
import tripMate.service.CostDivideService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/costDivide")
public class CostDivideServlet extends HttpServlet {
	private CostAddService addService = new CostAddService();
	private CostDivideService divideService = new CostDivideService();

	// GET 요청: 1/N 분배 폼 표시
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cost pending = (Cost) req.getSession().getAttribute("pendingCost");
		if (pending == null) {
			resp.sendRedirect(req.getContextPath() + "/costAdd");
			return;
		}

		// 일정 코드도 JSP에서 필요하므로 속성으로 저장
		req.setAttribute("sd_code", pending.getTripCode());
		// 참여자 목록 조회
		ArrayList<String> names = addService.getParticipantNames(pending.getTripCode());

		req.setAttribute("pending", pending);
		req.setAttribute("names", names);
		req.getRequestDispatcher("/WEB-INF/views/costDivide.jsp").forward(req, resp);
	}

	// POST 요청: 선택된 참여자에게 1/N 분배 후 저장
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Cost pending = (Cost) req.getSession().getAttribute("pendingCost");
		if (pending == null) {
			resp.sendRedirect(req.getContextPath() + "/costAdd");
			return;
		}

		String[] selected = req.getParameterValues("person");
		if (selected == null || selected.length == 0) {
			req.setAttribute("error", "참여자를 최소 한 명 이상 선택하세요.");
			req.setAttribute("pending", pending);
			req.setAttribute("names", addService.getParticipantNames(pending.getTripCode()));
			req.getRequestDispatcher("/WEB-INF/views/costDivide.jsp").forward(req, resp);
			return;
		}

		// 비용 저장 (단 한번)
		addService.addCost(pending);

		// 1/N 분배 금액 계산 (백 단위 반올림)
		int total = pending.getAmount(), count = selected.length;
		int share = (int) Math.round((double) total / count / 100.0) * 100;

		// 개인정산 기록 저장
		for (String nick : selected) {
			PersonalCost pc = new PersonalCost();
			pc.setPersonalCostId("P" + System.currentTimeMillis() + nick);
			pc.setCostId(pending.getCostId());
			pc.setUserCode(addService.getUserCodeByNickname(nick));
			pc.setPersonCost(share);
			String userCode = addService.getUserCodeByNickname(nick);
			pc.setUserCode(userCode);
			pc.setStatus(pc.getUserCode().equals(pending.getPayerCode()) ? "정산완료" : "정산대기중");
			pc.setPayer(pending.getPayerCode());
			divideService.addPersonalCost(pc);
		}

		req.getSession().removeAttribute("pendingCost");
		resp.sendRedirect(req.getContextPath() + "/cost?sd_code=" + pending.getTripCode());
	}
}
