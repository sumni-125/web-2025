package tripMate.service;

import tripMate.dao.UserDAO;
import tripMate.model.User;

public class loginService {
	UserDAO dao = new UserDAO();

	public User checkUser(String id, String pw) {
		return dao.checkUser(id, pw);
	}
}
