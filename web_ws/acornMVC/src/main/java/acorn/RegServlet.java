package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class RegServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//
		request.getRequestDispatcher("WEB-INF/views/regForm.jsp").forward(request, response);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		
		//사용자로부터 전송된 데이터에 대한 인코딩
		//한글
		request.setCharacterEncoding("UTF-8");
		
		String id  =request.getParameter("id");
		String pw= request.getParameter("pw");
		String name= request.getParameter("name");	
		
		Acorn acorn = new Acorn( id, pw, name);
		AcornService  service = new AcornService();
		service.registerMember(acorn);
		
		//request.getRequestDispatcher("WEB-INF/views/ok.jsp").forward(request, response);	
		
		response.sendRedirect("/acornMVC/acornlist");   // 다른 서비스를  호출하게 해줌  ( 자동으로 브라우저에게  재요청을 지정함)
	}
	
}
