package gameDBWeb;

import java.util.ArrayList;

public class GameService {

	GameDAO dao = new GameDAO();
	public ArrayList<GameWeb> getRecommendList(){
		ArrayList<GameWeb> list = dao.selectRecommend();
		return list;
	}
	
	public ArrayList<GameWeb> getStrList() {
		ArrayList<GameWeb> list = dao.selectWarrior();
		return list;
	}
	
	public ArrayList<GameWeb> getDexList() {
		ArrayList<GameWeb> list = dao.selectThief();
		return list;
	}
	
	public ArrayList<GameWeb> getIntList() {
		ArrayList<GameWeb> list = dao.selectMage();
		return list;
	}
	
	public void registerMember(GameAccount account) {
		dao.signUp(account);
	}
	
	//로그인
	public int login(String id, String pw) {
		int result = dao.login(id, pw);
		return result;
	}
}
