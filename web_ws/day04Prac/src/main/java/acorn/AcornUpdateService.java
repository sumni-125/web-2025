package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원정보 변경하기
//컨트롤러	:servlet
//모델	:데이터베이스에 변경하기
//뷰		: 변경성공페이지 응답

@WebServlet("/updateAcorn")
public class AcornUpdateService extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사용자정보 가져오기
		//한글인코딩
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		System.out.println(id+" "+pw+" "+name);
		
		//회원정보 변경하기 서비스
		AcornService s= new AcornService();
		s.modifyMember(id, pw);
		
		//응답
		resp.sendRedirect("/day04Prac/acornList");		
		
	}
	
}
