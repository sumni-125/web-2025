package tripMate.servlet;

import tripMate.model.PersonalCost;
import tripMate.model.Schedule;
import tripMate.service.PersonalCostService;
import tripMate.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/personalCost")
public class PersonalCostServlet extends HttpServlet {
	private PersonalCostService service = new PersonalCostService();
	private UserDAO userDao = new UserDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Unified parameter name 'sd_code'
		String sd_code = req.getParameter("sd_code");
		if (sd_code == null || sd_code.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "sd_code 파라미터가 필요합니다.");
			return;
		}

		// 1) 일정 정보 조회
		Schedule schedule = service.getSchedule(sd_code);
		String tripName = schedule.getName();
		String tripPeriod = schedule.getStart_date() + " ~ " + schedule.getEnd_date();

		// 2) 참여자 닉네임 목록 조회
		ArrayList<String> nameList = service.getParticipantNames(sd_code);
		String[] names = nameList.toArray(new String[0]);

		// 3) 닉네임 → USER_CODE 배열 생성
		String[] userCodes = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			userCodes[i] = userDao.getUser_code(nameList.get(i));
		}

		// 4) 개인 정산 전체 조회
		ArrayList<PersonalCost> personalList = service.getPersonalCostsByTrip(sd_code);

		// 닉네임으로 payer 필드 변환 (user_code → nickname)
		for (PersonalCost pc : personalList) {
			// userCode는 참여자
			String payerCode = pc.getPayer(); // 원래 결제자 코드
			pc.setPayerCode(payerCode); // 새로운 필드 (get/set 생성 필요)
			String nickname = userDao.getNicknameByUserCode(payerCode); // 닉네임 조회
			pc.setPayer(nickname);
		}

		// 5) 사용자별 정산 대기/완료 분리 버퍼 생성
		@SuppressWarnings("unchecked")
		ArrayList<PersonalCost>[] pendBuf = new ArrayList[names.length];
		@SuppressWarnings("unchecked")
		ArrayList<PersonalCost>[] compBuf = new ArrayList[names.length];
		for (int i = 0; i < names.length; i++) {
			pendBuf[i] = new ArrayList<>();
			compBuf[i] = new ArrayList<>();
		}
		for (PersonalCost pc : personalList) {
			for (int i = 0; i < userCodes.length; i++) {
				if (!userCodes[i].equals(pc.getUserCode()))
					continue;
				if ("정산대기중".equals(pc.getStatus()))
					pendBuf[i].add(pc);
				else
					compBuf[i].add(pc);
				break;
			}
		}

		// 6) 최종 배열로 변환
		PersonalCost[][] pending = new PersonalCost[names.length][];
		PersonalCost[][] complete = new PersonalCost[names.length][];
		for (int i = 0; i < names.length; i++) {
			pending[i] = pendBuf[i].toArray(new PersonalCost[0]);
			complete[i] = compBuf[i].toArray(new PersonalCost[0]);
		}

		// 7) 기본 선택 인덱스 설정
		String selectedIndex = "0";

		// 8) JSP에 속성 전달 (key 'sd_code' unified)
		req.setAttribute("sd_code", sd_code);
		req.setAttribute("tripName", tripName);
		req.setAttribute("tripPeriod", tripPeriod);
		req.setAttribute("nameList", names);
		req.setAttribute("pendingGiveList", pending);
		req.setAttribute("completedGiveList", complete);
		req.setAttribute("selectedIndex", selectedIndex);

		req.getRequestDispatcher("/WEB-INF/views/personalCost.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// 파라미터 받기
		String personalCostId = req.getParameter("personalCostId");
		String personIndex = req.getParameter("personIndex");
		String sdCode = req.getParameter("sd_code");

		// 예외처리: 필수값 누락 시 에러 처리
		if (personalCostId == null || personIndex == null || sdCode == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "필수 파라미터 누락");
			return;
		}

		// 상태 업데이트 (정산완료로)
		PersonalCostService service = new PersonalCostService();
		service.updateStatus(personalCostId, "정산완료");

		// 다시 개인정산페이지로 리다이렉트 (해당 사용자 선택 유지)
		resp.sendRedirect(req.getContextPath() + "/personalCost?sd_code=" + sdCode + "&personIndex=" + personIndex);
	}

}