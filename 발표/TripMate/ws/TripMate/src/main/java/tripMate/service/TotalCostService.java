package tripMate.service;

import java.util.ArrayList;

import tripMate.dao.CategoryDAO;
import tripMate.dao.CostDAO;
import tripMate.dao.PersonalCostDAO;
import tripMate.dao.ScheduleDAO;
import tripMate.dao.TripMemberDAO;
import tripMate.model.Cost;
import tripMate.model.PersonalCost;
import tripMate.model.Schedule;

public class TotalCostService {
	private CategoryDAO catdao = new CategoryDAO(); // 카테고리 DAO
	private CostDAO costDao = new CostDAO(); // 비용 DAO
	private PersonalCostDAO pcDao = new PersonalCostDAO();// 개인비용 DAO
	private ScheduleDAO scheduleDao = new ScheduleDAO(); // 일정 DAO
	private TripMemberDAO tmDao = new TripMemberDAO(); // 참여자 DAO
	
	// 모든 카테고리 조회
	public ArrayList<String> getAllCategories() {
        return catdao.getAllCategories();
    }

	// 모든 비용 조회
	public ArrayList<Cost> getAllCosts(String sdCode) {
		return costDao.getCostsByTrip(sdCode);
	}

	// 모든 개인비용 조회
	public ArrayList<PersonalCost> getAllPersonalCosts(String sdCode) {
		return pcDao.getPersonalCostsByTrip(sdCode);
	}

	// 일정 단일 조회
	public Schedule getSchedule(String sdCode) {
		return scheduleDao.getScheduleByCode(sdCode);
	}

	// 일정별 참여자 닉네임 조회
	public ArrayList<String> getParticipantNames(String sdCode) {
		return tmDao.getParticipantNicknamesBySchedule(sdCode);
	}
	
}
