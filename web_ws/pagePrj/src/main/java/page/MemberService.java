package page;

import java.util.ArrayList;

public class MemberService {
	
	MemberDao dao = new MemberDao();
	
	public ArrayList<Member> getMembers( int page, int pageSize){
		return dao.getListPage(page, pageSize);
	}
	
	public int getTotal() {
		return dao.getTotal();
	}

}
