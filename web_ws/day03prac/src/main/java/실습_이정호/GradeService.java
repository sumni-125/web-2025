package 실습_이정호;

import java.util.ArrayList;

public class GradeService {
	public ArrayList<Grade> getList(){
		ArrayList<Grade> list = new ArrayList<>();
		
		list.add(new Grade("Lee", 100, 80, 90));
		list.add(new Grade("Kim", 90, 85, 90));
		list.add(new Grade("Park", 90, 100, 80));
		list.add(new Grade("Choi", 80, 95, 80));
		list.add(new Grade("Jo", 70, 85, 100));
		
		return list;
	}
}
