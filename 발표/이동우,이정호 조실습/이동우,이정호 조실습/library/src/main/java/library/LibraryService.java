package library;

import java.util.ArrayList;

public class LibraryService {

	
	
	//dao
	
	LibraryDAO dao = new LibraryDAO();
	
	
	//조회하기
	public ArrayList<Library> getLibraryList(){
		
		ArrayList<Library> list = dao.selectAll();
		return list;
		
	}
	
	public ArrayList<Library> getLibraryOne(){
		
		ArrayList<Library> ol = dao.selectOne();
		return ol;
		
	}
	
	//변경하기
	public void modifySeat(String seat_id) {
		dao.update(seat_id);
	}
	
	//취소하기
	public void cancelSeat(String seat_id) {
	    dao.cancelSeat(seat_id);
	}
	
}
