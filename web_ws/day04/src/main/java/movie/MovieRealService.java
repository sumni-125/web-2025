package movie;

import java.util.ArrayList;

public class MovieRealService {
	
	MovieDAO dao = new MovieDAO();
	
	
	public ArrayList<Movie> getMovieList(){			
		ArrayList<Movie> list  =	dao.selectAll();
		
		System.out.println( list);
		return list;		
	}

}
