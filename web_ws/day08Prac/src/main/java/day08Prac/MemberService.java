package day08Prac;

import java.util.ArrayList;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();
	
	public ArrayList<Member> getListPage(int currentPage){
		return dao.selectPage(currentPage);
	}
	
	public int getTotal() {
		return dao.getTotal();
	}
	
	public ArrayList<Member> selectAll(){
		return dao.selectAll();
	}
	
}
