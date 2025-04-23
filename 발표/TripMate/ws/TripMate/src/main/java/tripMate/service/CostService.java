package tripMate.service;

import java.util.ArrayList;
import tripMate.dao.CostDAO;
import tripMate.dao.ScheduleDAO;
import tripMate.dao.TripMemberDAO;
import tripMate.dao.UserDAO;
import tripMate.model.Cost;
import tripMate.model.Schedule;

public class CostService {
	private CostDAO costDao = new CostDAO(); // 비용 DAO
	private ScheduleDAO scheduleDao = new ScheduleDAO(); // 일정 DAO
	private TripMemberDAO tmDao = new TripMemberDAO(); // 참여자 DAO
	private UserDAO userDao = new UserDAO(); // 사용자 DAO

	// 여행별 비용 목록 조회
	public ArrayList<Cost> getCostsByTrip(String tripCode) {
		return costDao.getCostsByTrip(tripCode);
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