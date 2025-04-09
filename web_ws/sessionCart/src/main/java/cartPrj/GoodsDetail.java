package cartPrj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/goodsDetail")
public class GoodsDetail   extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String goodscode= req.getParameter("goodscode");
		if(goodscode== null)  goodscode="t01";
		 
		//Model 구하기
		GoodsService s = new GoodsService();
		String goods= s.getGoods(goodscode);
		//Model 심기
		
		
		System.out.println( goods);
		
		//모델심기
		req.setAttribute("goods", goods);
		
		req.getRequestDispatcher("WEB-INF/views/goodsDetail.jsp").forward(req, resp);
	}

}
