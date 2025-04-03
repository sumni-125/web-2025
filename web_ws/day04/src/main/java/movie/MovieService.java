package movie;

import java.util.ArrayList;

public class MovieService {
	
	
	
	public ArrayList<Movie>  getMoveListAll(){
				
		
		ArrayList<Movie> list = new ArrayList<>();
		
		list.add( new Movie( "m001" , "반지의 제왕" , "https://m.media-amazon.com/images/I/51Qvs9i5a%2BL._AC_.jpg" ,"SF"));
		list.add( new Movie( "m002" , "매트릭스 " ,"https://m.media-amazon.com/images/I/51EG732BV3L._AC_.jpg" ,"SF"));
		list.add( new Movie( "m003", "인터스텔라", "https://m.media-amazon.com/images/I/A1JVqNMI7UL._AC_SY679_.jpg" ,"SF"));
		
		return list;
		
		
	}

}
