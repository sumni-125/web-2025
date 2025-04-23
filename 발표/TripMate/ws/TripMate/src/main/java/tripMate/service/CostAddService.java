package tripMate.service;

import java.util.ArrayList;
import tripMate.dao.CategoryDAO;
import tripMate.dao.PaymentTypeDAO;
import tripMate.dao.PaymentMethodDAO;
import tripMate.dao.CostDAO;
import tripMate.dao.PersonalCostDAO;
import tripMate.dao.ScheduleDAO; // 일정 조회 DAO
import tripMate.dao.TripMemberDAO;
import tripMate.dao.UserDAO;
import tripMate.model.Cost;
import tripMate.model.PersonalCost;
import tripMate.model.Schedule;

public class CostAddService {
	private CategoryDAO catDao = new CategoryDAO(); // 카테고리 DAO
	private PaymentTypeDAO typeDao = new PaymentTypeDAO(); // 결제수단 DAO
	private PaymentMethodDAO methodDao = new PaymentMethodDAO(); // 결제방식 DAO
	private CostDAO costDao = new CostDAO(); // 비용 DAO
	private PersonalCostDAO personalDao = new PersonalCostDAO(); // 개인비용 DAO
	private ScheduleDAO scheduleDao = new ScheduleDAO(); // 일정 DAO
	private TripMemberDAO tmDao = new TripMemberDAO(); // 참여자 DAO
	private UserDAO userDao = new UserDAO(); // 사용자 DAO

	// 카테고리 목록 조회
	public ArrayList<String> getAllCategories() {
		return catDao.getAllCategories();
	}

	// 결제수단 목록 조회
	public ArrayList<String> getAllPaymentTypes() {
		return typeDao.getAllPaymentTypes();
	}

	// 결제방식 목록 조회
	public ArrayList<String> getAllPaymentMethods() {
		return methodDao.getAllPaymentMethods();
	}

	// 일정 정보 조회 (스케줄 상세)
	public Schedule getSchedule(String sdCode) {
		return scheduleDao.getScheduleByCode(sdCode);
	}

	// 일정별 참여자 닉네임 조회 로직을 DAO로 위임
	public ArrayList<String> getParticipantNames(String sdCode) {
		return tmDao.getParticipantNicknamesBySchedule(sdCode);
	}

	// 닉네임으로 사용자 코드 조회
	public String getUserCodeByNickname(String nickname) {
		return userDao.getUser_code(nickname);
	}

	// 비용 저장
	public void addCost(Cost cost) {
		costDao.insertCost(cost);
	}

	// 개인비용 저장
	public void addPersonalCost(PersonalCost pc) {
		personalDao.insertPersonalCost(pc);
	}
}