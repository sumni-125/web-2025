package movie;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 영화조회 서비스
// servlet
// mvc - servlet ( controller ) , jsp ( view ) , 데이터 ( model ) - 순수 자바( pojo ) MVC2패턴

@WebServlet("/movieAll2")
public class MovieServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MovieService service = new MovieService();
		ArrayList<Movie> list = service.getMoveListAll();

		req.setAttribute("list", list);

		req.getRequestDispatcher("WEB-INF/views/movieList.jsp").forward(req, resp);

	}
}
