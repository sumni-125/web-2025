package sample;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jstl2")
public class Jstl2  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		ArrayList<Music >  music= new ArrayList<>();
		 
		music.add( new Music("밤양갱" , "비비"));
		music.add( new Music("ak47" , "맨스티어"));
		music.add( new Music("우리들의블루스" , "임영웅")); 		
		

		request.setAttribute("music", music);
		
		request.getRequestDispatcher("WEB-INF/views/jstl2.jsp").forward(request, response);
	}
}
