package cartPrj;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list")
public class GoodsListServlet  extends HttpServlet{
	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		 
		 
		 GoodsService s = new GoodsService();
		 ArrayList<String> list  = s.getList();
		 
		 
		 //모델에 저장하기
		 req.setAttribute("list", list);	 
		 
		 
		 //상품 뷰로 포워드
		 //상품리스트 뷰가 응답됨
		 req.getRequestDispatcher("WEB-INF/views/goods_list.jsp").forward(req, resp);
	}

}
