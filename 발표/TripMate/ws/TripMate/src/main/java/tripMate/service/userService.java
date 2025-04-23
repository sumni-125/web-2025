package tripMate.service;

import tripMate.dao.UserDAO;
import tripMate.model.User;

public class userService {
	UserDAO dao = new UserDAO();
	public void updateUserData(User user) {
		dao.UpdateUser(user);
	}
}
