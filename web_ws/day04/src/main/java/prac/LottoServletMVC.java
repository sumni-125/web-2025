package prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Lotto")
public class LottoServletMVC extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String su_ = req.getParameter("su");
			int su = 1;
			if(su_!=null) {
				su = Integer.parseInt(su_);
			}
			
			System.out.println(su);
			
			LottoService2 service = new LottoService2();
			int[] result = service.getLotto(su);
			
			
			req.setAttribute("lotto", result);			
			req.getRequestDispatcher("WEB-INF/views/lottoView.jsp").forward(req, resp);
	}

}
