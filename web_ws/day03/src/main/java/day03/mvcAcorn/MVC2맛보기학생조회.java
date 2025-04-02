package day03.mvcAcorn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//서블릿 ( controller)
//jsp  ( view) 
//Model ( 에이콘학생목록 - ArrayList<acorn>  )

@WebServlet("/acornList")
public class MVC2맛보기학생조회 extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        
        //데이터 만들기  (Model)
		AcornDAO dao = new AcornDAO();
		ArrayList<Acorn> list  =dao.getAllAcorns();
		
		//데이터 저장하기 (서블릿과 jsp가 함께쓰는 저장소  request)
		
		//View로 포워드
		request.setAttribute("list", list);		
		request.getRequestDispatcher("WEB-INF/views/list.jsp").forward(request, response);
	
    }
		
		
	 
}
