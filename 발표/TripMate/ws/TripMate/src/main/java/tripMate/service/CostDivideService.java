package tripMate.service;

import tripMate.dao.PersonalCostDAO;
import tripMate.model.PersonalCost;

public class CostDivideService {
	private PersonalCostDAO dao = new PersonalCostDAO(); // 개인비용 DAO

	// 개인비용 저장
	public void addPersonalCost(PersonalCost pc) {
		dao.insertPersonalCost(pc);
	}
}