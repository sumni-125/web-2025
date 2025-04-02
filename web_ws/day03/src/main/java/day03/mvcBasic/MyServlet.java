package day03.mvcBasic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//Servlet  => Controller
//view     => View
//데이터(서비스할  데이터) = > Model (자바)



//이것이 controller이다 

@WebServlet("/mycontroller")  //요청받기
public class MyServlet  extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		
		 
		
		//필요한 데이터 만들기   ( Model)		
		HapService  service = new HapService();
		int model  = service.getTotalSum();
		
		
		
		//공유저장소에 저장
		request.setAttribute("hap", model); 
		
		//view로 가서 응답해
		request.getRequestDispatcher("WEB-INF/views/myview.jsp").forward(request, response);
		
		
		
		
		// 포워드
		// 클라이언트가 요청한 데이터를 유지한 채로 다른 jsp로 요청을 전달함 
		// 서버 내부에서 처리됨
		// view를 거쳐서 가라는 의미
		// 포워드는 서버 내부에서 이동하는 것이라 url이 안바뀌고  request데이터도 유지가 됨 !! 
		
	}
}
