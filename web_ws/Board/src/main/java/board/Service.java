package board;

public class Service {
	
	//BoardDAO bdao = new BoardDAO();
	MemberDAO mdao = new MemberDAO();
	
	
	
	public Member selectMember(String id) {
		Member member = mdao.selectOne(id);
		
		return member;
	}
	
	
}
