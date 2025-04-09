package page;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list3.page")
public class ListPageServlet3 extends HttpServlet{	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	int currentPage=1 ;
	if( request.getParameter("p") != null )	 
		currentPage= Integer.parseInt(request.getParameter("p"));
	
	
	 MemberService  service = new MemberService();
	 
	 //별도의 자바파일로 분리해도 좋음 
	 int pageSize=2;
	 int grpSize =5;
	 
	 
	 ArrayList<Member> list =service.getMembers(currentPage, pageSize); // 목록     
	 int totRecords =service.getTotal() ; // 총 레코드 수 
	
	 
	 PageHandler handler = new PageHandler( currentPage , totRecords ,pageSize,grpSize);
	 
	 
	 //현제페이지 정보와 목록 정보 저장하기	 
	 request.setAttribute("list1", list);
	 request.setAttribute("paging", handler);		 
	 request.getRequestDispatcher("WEB-INF/views/listPage3.jsp").forward(request, response);	 
	 
	}

}
