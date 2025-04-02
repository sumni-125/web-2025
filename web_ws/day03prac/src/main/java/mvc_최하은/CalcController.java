package mvc_최하은;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcMVC")
public class CalcController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num1 = req.getParameter("su1");
		String num2 = req.getParameter("su2");
		
		int su1 = Integer.parseInt(num1);
		int su2 = Integer.parseInt(num2);
		
		//모델 만들기
		CalcService service = new CalcService();
		
		int add = service.getAdd(su1, su2);
		int minu = service.getMinu(su1, su2);
		int mul = service.getMul(su1, su2);
		int div = service.getDiv(su1, su2);
		
		//응답
		req.setAttribute("num1", su1);
		req.setAttribute("num2", su2);
		req.setAttribute("add", add);
		req.setAttribute("minus", minu);
		req.setAttribute("multiple", mul);
		req.setAttribute("divide", div);
		req.getRequestDispatcher("WEB-INF/views/calcView_최하은.jsp").forward(req, resp);
		
	}
	
}
