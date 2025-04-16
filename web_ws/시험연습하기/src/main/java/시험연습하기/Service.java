package 시험연습하기;

import java.util.ArrayList;

public class Service {
	TestDAO dao = new TestDAO();

	public ArrayList<Acorn> selectAll() {

		ArrayList<Acorn> list = dao.selectAll();

		return list;

	}

}
