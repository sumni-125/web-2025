package tripMate.servlet;

import tripMate.model.Cost;
import tripMate.model.PersonalCost;
import tripMate.model.Schedule;
import tripMate.service.TotalCostService;
import tripMate.dao.UserDAO;
import tripMate.dao.CategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/totalCost")
public class TotalCostServlet extends HttpServlet {
	private TotalCostService service = new TotalCostService();
	private UserDAO userDao = new UserDAO();
	private CategoryDAO categoryDao = new CategoryDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Unified parameter name 'sd_code'
		String sd_code = req.getParameter("sd_code");
		if (sd_code == null || sd_code.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "sd_code가 필요합니다.");
			return;
		}

		// 1) 데이터 조회
		ArrayList<Cost> costList = service.getAllCosts(sd_code);
		ArrayList<PersonalCost> pcList = service.getAllPersonalCosts(sd_code);
		ArrayList<String> nameList = service.getParticipantNames(sd_code);
		String[] names = nameList.toArray(new String[0]);

		// 2) 필터 파라미터 처리
		String filterName = req.getParameter("filterName");
		String filterCode = (filterName != null) ? userDao.getUser_code(filterName) : null;
		int filterIndex = -1;
		if (filterName != null) {
			for (int i = 0; i < names.length; i++) {
				if (names[i].equals(filterName)) {
					filterIndex = i;
					break;
				}
			}
		}

		// 3) 카테고리 목록 DB 조회
		ArrayList<String> categoryList = categoryDao.getAllCategories();
		String[] categories = categoryList.toArray(new String[0]);
		int[] sums = new int[categories.length];

		// 4) 합계 계산
		if (filterCode != null) {
			for (PersonalCost pc : pcList) {
				if (!filterCode.equals(pc.getUserCode()))
					continue;
				for (Cost c : costList) {
					if (!c.getCostId().equals(pc.getCostId()))
						continue;
					for (int k = 0; k < categories.length; k++) {
						if (categories[k].equals(c.getCategory())) {
							sums[k] += pc.getPersonCost();
							break;
						}
					}
					break;
				}
			}
		}

		// 5) 배열 변환 및 일정 조회
		Cost[] costs = costList.toArray(new Cost[0]);
		PersonalCost[] pcs = pcList.toArray(new PersonalCost[0]);
		Schedule schedule = service.getSchedule(sd_code);

		// 6) JSP 속성 전달
		req.setAttribute("sd_code", sd_code);
		req.setAttribute("tripName", schedule.getName());
		req.setAttribute("tripPeriod", schedule.getStart_date() + " ~ " + schedule.getEnd_date());
		req.setAttribute("names", names);
		req.setAttribute("filterName", filterName);
		req.setAttribute("filterIndex", filterIndex);
		req.setAttribute("categories", categories);
		req.setAttribute("sums", sums);
		req.setAttribute("costs", costs);
		req.setAttribute("pcs", pcs);
		req.setAttribute("filterUserCode", filterCode);

		req.getRequestDispatcher("/WEB-INF/views/totalCost.jsp").forward(req, resp);
	}
}
