package 발표;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculatedd")
public class 사칙연산_황예지 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String su = request.getParameter("su1");
		String su_ = request.getParameter("su2");

		int su1 = Integer.parseInt(su);
		int su2 = Integer.parseInt(su_);
		
		int sum = su1 + su2;
		int sub = su1 - su2;
		int mul = su1 * su2;
		double div = (double) su1 / su2;

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>1. 두 수를 입력받아서 사칙연산 제공하기</h1>");
		out.println("<h2>" + su1 + "+" + su2 + "=" + sum + "</h2>");
		out.println("<h2>" + su1 + "-" + su2 + "=" + sub + "</h2>");
		out.println("<h2>" + su1 + "×" + su2 + "=" + mul + "</h2>");
		out.println("<h2>" + su1 + "÷" + su2 + "=" + div + "</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
