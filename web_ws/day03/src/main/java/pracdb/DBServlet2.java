package pracdb;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/acornlist2")
public class DBServlet2  extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		
		
		//데이터 만들기
		AcornDAO  dao = new AcornDAO();
		ArrayList <Acorn> list  =dao.getAcornList();
		
		
		System.out.println(  list);
		
		//서블릿에서 직접 응답하기 
		//jsp(view)를 사용해서응답하기  - 
		
		
		//request 저장소에  view에서 사용할  데이터 저장하기
		req.setAttribute("list", list);

		//jsp로 포워드 하기 
		req.getRequestDispatcher("WEB-INF/views/list.jsp").forward(req, resp);
		
		
	}
}
