package tripMate.service;

import java.util.ArrayList;
import tripMate.dao.ScheduleDAO;
import tripMate.model.Schedule;
import tripMate.model.User;

public class ScheduleService {
	private ScheduleDAO dao = new ScheduleDAO();

	public ArrayList<Schedule> getScheduleList(User user) {
		return dao.getScheduleList(user);
	}
}
