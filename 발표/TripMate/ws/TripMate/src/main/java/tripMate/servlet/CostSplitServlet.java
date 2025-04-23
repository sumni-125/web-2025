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

@WebServlet("/costSplit")
public class CostSplitServlet extends HttpServlet {
	private CostAddService addService = new CostAddService();
	private CostDivideService splitService = new CostDivideService();

	// GET 요청: 한번에결제 폼 표시
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1) 세션에서 pendingCost 꺼내기
		Cost pending = (Cost) req.getSession().getAttribute("pendingCost");
		if (pending == null) {
			// pendingCost 가 없으면, 비용 추가 페이지로 보내기
			resp.sendRedirect(req.getContextPath() + "/costAdd");
			return;
		}

		// 2) JSP에 전달할 속성 설정
		req.setAttribute("sd_code", pending.getTripCode());
		req.setAttribute("pending", pending);

		// ★ 수정된 부분: List<String> → String[] 배열로 변환하여 넘김
		ArrayList<String> namesList = addService.getParticipantNames(pending.getTripCode()); // 참여자 리스트 조회
		String[] namesArray = namesList.toArray(new String[0]); // 배열로 변환
		req.setAttribute("names", namesArray); // 배열로 JSP에 전달

		// 3) 뷰 포워드
		req.getRequestDispatcher("/WEB-INF/views/costSplit.jsp").forward(req, resp);
	}

	// POST 요청: 입력된 금액만큼 개인정산 저장
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Cost pending = (Cost) req.getSession().getAttribute("pendingCost");
		if (pending == null) {
			resp.sendRedirect(req.getContextPath() + "/costAdd");
			return;
		}

		// 비용 먼저 저장해서 costId 생성
		addService.addCost(pending); // 이 안에서 costId 세팅됨

		// 체크박스로 넘어오는 참여자 파라미터 읽기
		String[] participants = req.getParameterValues("person");
		// null 또는 아무도 선택하지 않은 경우 예외 처리
		if (participants == null || participants.length <= 1) {
			// 폼으로 다시 돌아가면서 에러 메시지 띄우기
			req.setAttribute("error", "둘 이상의 참여자를 선택해주세요.");
			doGet(req, resp);
			return;
		}

		// 선택된 참여자 이름 배열로 순회
		for (String nick : participants) {
			// 각 텍스트 필드(name=nick) 에서 입력값 꺼내기
			String val = req.getParameter(nick);
			if (val != null && !val.isEmpty()) {
				int amount = Integer.parseInt(val);
				PersonalCost pc = new PersonalCost();
				pc.setPersonalCostId("P" + System.currentTimeMillis() + nick);
				pc.setCostId(pending.getCostId());
				pc.setUserCode(addService.getUserCodeByNickname(nick));
				pc.setPersonCost(amount);
				pc.setStatus(pc.getUserCode().equals(pending.getPayerCode()) ? "정산완료" : "정산대기중");
				pc.setPayer(pending.getPayerCode());
				splitService.addPersonalCost(pc);
			}
		}

		req.getSession().removeAttribute("pendingCost");
		resp.sendRedirect(req.getContextPath() + "/cost?sd_code=" + pending.getTripCode());
	}
}
