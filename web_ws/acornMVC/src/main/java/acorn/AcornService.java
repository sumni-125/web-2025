package acorn;

import java.util.ArrayList;

public class AcornService {

	
	AcornDAO dao = new AcornDAO();
	
	//학생정보가져오기 ( 매개변수 ,  반환 )	
	public ArrayList<Acorn> getMemberListTmp(){		
		ArrayList<Acorn>  list =  new  ArrayList<>();		
		list.add( new Acorn("dh","1234","김도현"));
		list.add( new Acorn("mg","5678","김무궁"));
		list.add( new Acorn("sj","4682","김세중"));				
		return list;		
		
	}
	
	public ArrayList<Acorn> getMemberListReal(){		
		ArrayList<Acorn> list  =dao.selectAll();
		return list;		
	}
	
		
	public void registerMember(Acorn acorn) {		
		dao.insertMember(acorn);
	}
	
	public static void main(String[] args) {
		AcornService service = new AcornService();
		ArrayList<Acorn>  list=service.getMemberListReal();
		
		for( int i=0; i< list.size() ; i++) {
			 System.out.println( list.get(i));
		} 		
	}
	
	public Acorn getMember(String id ) {		
		Acorn acorn  = dao.selectOne(id);
		return acorn;
	}
	
	
	
	public void deleteMember( String id) {
		dao.delete(id);
	}
	
	public  void modifyMember( String id, String newpw) {
		dao.update(id, newpw);
	}
	
	
	
}
