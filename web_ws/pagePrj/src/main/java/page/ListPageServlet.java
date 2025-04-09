package page;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list.page")
public class ListPageServlet extends HttpServlet{	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int currentPage=1 ;
	if( request.getParameter("p") != null )	 
		currentPage= Integer.parseInt(request.getParameter("p"));
	
	 MemberService  service = new MemberService();	
	 int pageSize=2;
	 ArrayList<Member> list =service.getMembers(currentPage, pageSize); // 목록     
	 int totRecords =service.getTotal() ; // 총 레코드 수 
	 
	 //현제페이지 정보와 목록 정보 저장하기	 
	 
	 
	 request.setAttribute("list1", list);         // 페이징된 목록
	 request.setAttribute("p", currentPage);      // 현재 페이지  
	 request.setAttribute("totCnt", totRecords);  // 전체레코드 수 
	 request.setAttribute("pageSize", pageSize);  // 전체레코드 수 
	 
	 
	 request.getRequestDispatcher("WEB-INF/views/listPage.jsp").forward(request, response);	 
	 
	}

}
