package acorn;

import java.util.ArrayList;

public class AcornService {
	
	AcornDAO dao = new AcornDAO();
	
	public void registerMember( Acorn acorn ) {
		
		dao.insertMember(acorn);
		
	}
	
	public ArrayList<Acorn> getMemberList(){
		
		ArrayList<Acorn> list = dao.selectAll();
		return list;
	}
	
	public Acorn getMemberInfo(String id) {
		
		Acorn acorn = dao.selectOne(id);
		
		return acorn;
	}
	
	//회원정보 변경하기
	public void modifyMember(String id, String pw) {
		dao.update(id, pw);
	}
	
	//회원삭제
	public void deleteMember(String id) {
		dao.delete(id);
	}
	
}
