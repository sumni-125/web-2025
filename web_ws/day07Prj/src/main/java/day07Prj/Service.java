package day07Prj;

public class Service {
	
	//BoardDAO bdao = new BoardDAO();
	MemberDAO mdao = new MemberDAO();
	
	public void insertBoard(Board board) {
	//	bdao.insert(board);
	}
	
	public void updateBoard(Board board) {
		//bdao.update(board);
	}
	
	public Member selectMember(String id) {
		Member member = mdao.selectOne(id);
		
		return member;
	}
	
	
}
