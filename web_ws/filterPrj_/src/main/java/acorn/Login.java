package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login  extends HttpServlet{
	
	//로그인화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		 
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //로그인처리	
		 
		//req.setCharacterEncoding("UTF-8");
		
		String id  = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		System.out.println( id);
		System.out.println( pw);
		
		
		if( isValid( id, pw)) {  //정상적인   id, pw
			//세션등록
			HttpSession  session   =req.getSession();
			session.setAttribute("id", id);		  		
			resp.sendRedirect("/filterPrj_/home");
			
		}else {
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		} 		
	} 	
	
	boolean isValid( String id, String pw) {		
		boolean result =false;
		if( id.equals(pw)) result=true;
		return result;		
	}
	
}
