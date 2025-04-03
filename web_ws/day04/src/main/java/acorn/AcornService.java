package acorn;

public class AcornService {
	
	AcornDAO dao = new AcornDAO();
	
	public void  registerMember( Acorn acorn) {
		
		dao.insertMember(acorn);
		
	}

}
