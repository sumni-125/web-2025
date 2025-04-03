package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 에이콘학생 등록하는 서비스  (회원가입서비스)
// get: 등록화면
// post :  실제 데이터베이스에 등록하기 


@WebServlet("/acornReg")
public class AcornRegServlet  extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		
		req.getRequestDispatcher("WEB-INF/views/acornReg.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  		
		System.out.println("post");
		
		//1.사용자가 입력한 회원정보 가져오기 
		//2.데이터베이스에 추가하기 
		
		//form에서 전송된 데이터는  각  input의 name값으로 꺼내온다 
		
		
		req.setCharacterEncoding("utf-8");
		
		String id  =req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		System.out.println( id);
		System.out.println( pw);
		System.out.println( name);
		
		
		String[]  hobby = req.getParameterValues("hobby");
		
		for( int i=0;  i< hobby.length; i++){
			System.out.println(hobby[i] );
		}
		
		
		// 
		
		Acorn acorn = new Acorn( id, pw, name);
		AcornService service  = new AcornService();
		service.registerMember(acorn);
		
		
		req.getRequestDispatcher("WEB-INF/views/ok.jsp").forward(req, resp);
		
		
	} 
	
}
