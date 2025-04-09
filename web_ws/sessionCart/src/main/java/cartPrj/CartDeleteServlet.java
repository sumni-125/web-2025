package cartPrj;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/deleteCart")
public class CartDeleteServlet   extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		String name  = req.getParameter("name");
		 
		
		HttpSession session = req.getSession();
		Object result =  session.getAttribute("cartList");
		
		
		//세션에  cartList 가 있으면
		if( result != null) {
			ArrayList<String> cartList   = (ArrayList<String>) result;				
			
			//해당 항목 삭제
			int removeIndex=-1;
			for( int i=0; i< cartList.size() ;i ++) {
				if( cartList.get(i).equals(name)) {
					removeIndex  = i;
					break;
				}
			}	
			
			cartList.remove(removeIndex);
		} 
		
		
		
		req.getRequestDispatcher("WEB-INF/views/cartList.jsp").forward(req, resp);
	}

}
