package cartPrj;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cart")
public class CartListServlet  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		HttpSession session = req.getSession();
		Object result =  session.getAttribute("cartList");
		
		
		//세션에서 장바구니 가져오기가 있으면
		if( result != null) {
			ArrayList<String> list = (ArrayList<String>) result;
			req.getRequestDispatcher("WEB-INF/views/cartList.jsp").forward(req, resp);
			 
		}
		
		
	}

}
