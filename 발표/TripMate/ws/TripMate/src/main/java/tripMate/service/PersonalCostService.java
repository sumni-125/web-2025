// File: tripMate/service/PersonalCostService.java
package tripMate.service;

import java.util.ArrayList;

import tripMate.dao.PersonalCostDAO;
import tripMate.dao.TripMemberDAO;
import tripMate.dao.ScheduleDAO; // 일정 조회 DAO
import tripMate.model.PersonalCost;
import tripMate.model.Schedule;

public class PersonalCostService {
	private PersonalCostDAO costDao = new PersonalCostDAO();
	private TripMemberDAO memberDao = new TripMemberDAO();
	private ScheduleDAO scheduleDao = new ScheduleDAO();

	// 1) 여행(sdCode)별 개인비용 전체 조회
	public ArrayList<PersonalCost> getPersonalCostsByTrip(String sdCode) {
		return costDao.getPersonalCostsByTrip(sdCode);
	}

	// 2) 개인비용 상태 변경
	public void updateStatus(String personalCostId, String status) {
		costDao.updateStatus(personalCostId, status);;
	}

	// 3) 일정별 참여자 닉네임 목록 조회
	public ArrayList<String> getParticipantNames(String sdCode) {
		return memberDao.getParticipantNicknamesBySchedule(sdCode);
	}

	// 4) 일정 정보 객체 자체를 DAO에서 받아옴
	public Schedule getSchedule(String sdCode) {
		return scheduleDao.getScheduleByCode(sdCode);
	}
}
