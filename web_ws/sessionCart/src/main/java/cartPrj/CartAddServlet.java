package cartPrj;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/addCart")
public class CartAddServlet   extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		String name  = req.getParameter("name");
		
	 
		
		//세션 : 서버측의 정보를 저장하는 기술이다 
		//웹은 요청이 되고 응답이 되면 하나의 요청이 종료됨 
		//웹은 이전상태를 저장하지 않는다
		//이전 작업이 로그인 작업이어도 그 이후 작업이 로그인과 아무런 관련이 없다 
		//그래서 로그인정보를 저장하고 사용해야 한다
		//상태정보를 저장하는 기술중에 서버에 정보를 저장하는 저장소로  request,  session ,  ServletContext (ApplicationContext )
		//이 중에 클라이언트마다 부여하고 사용할 수 있는 저장소가 바로 session 이다
		
		
		//각 클라이언트마다 하나의 저장소가 제공됨  (  각 클라이언트의 고유의 ID를 발급받기 때문에 각 각의 클라이언트를 식별할 수  있음)
		//세션 저장소 얻어오기
		HttpSession session = req.getSession();
		Object result =  session.getAttribute("cartList");
		
		
		
		//세션에 cartList가 있는경우
		if( result != null) {
			ArrayList<String> cartList   = (ArrayList<String>) result; 
			cartList.add(name);
			
		}else {  // 세션에  cartList가 없는 경우
			
			ArrayList<String> cartList   =  new ArrayList<String> ();
			cartList.add(name);
			
			
			//세션저장소에 저장하기
			session.setAttribute("cartList" , cartList);
			
		}
		
		
		
		
		// 장바구니리스트 서비스 요청하기
		
		
		 //프로젝트명 얻어오기
		 String  path= req.getServletContext().getContextPath();
		 resp.sendRedirect(path +"/cart");
		 // resp.sendRedirect(/sessionCart/cart");
	}

}
