package mvc실습하기;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class EleventhServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		PrintWriter out = resp.getWriter();

		String su1Str = req.getParameter("su1");
		String su2Str = req.getParameter("su2");
		String choiceStr = req.getParameter("choice");

		out.println("<html>");
		out.println("<head><title>자동 계산</title></head>");
		out.println("<body>");

		if (su1Str == null || su2Str == null || choiceStr == null) {
			out.println("<script>");
			out.println("let su1 = prompt('첫 번째 숫자를 입력하세요:');");
			out.println("let su2 = prompt('두 번째 숫자를 입력하세요:');");
			out.println("let choice = prompt('사칙연산 선택: 1.+  2.-  3.*  4./  5.%');");
			out.println(
					"if (su1 !== null && su2 !== null && choice !== null && su1.trim() !== '' && su2.trim() !== '' && choice.trim() !== '') {");
			out.println(
					"    location.href = 'calculate?su1=' + encodeURIComponent(su1) + '&su2=' + encodeURIComponent(su2) + '&choice=' + encodeURIComponent(choice);");
			out.println("</script>");
		} else {

			int su1 = Integer.parseInt(su1Str);
			int su2 = Integer.parseInt(su2Str);
			int choice = Integer.parseInt(choiceStr);

			out.println("<h2>계산 결과</h2>");
			switch (choice) {
			case 1:
				out.println("<p>" + su1 + " + " + su2 + " = " + (su1 + su2) + "</p>");
				break;
			case 2:
				out.println("<p>" + su1 + " - " + su2 + " = " + (su1 - su2) + "</p>");
				break;
			case 3:
				out.println("<p>" + su1 + " * " + su2 + " = " + (su1 * su2) + "</p>");
				break;
			case 4:
					out.println("<p>" + su1 + " / " + su2 + " = " + ((double) su1 / su2) + "</p>");
				break;
			case 5:
					out.println("<p>" + su1 + " % " + su2 + " = " + (su1 % su2) + "</p>");				
				break;
			default:
				out.println("<p>잘못된 연산 선택입니다.</p>");
			}
		}
		out.println("</body></html>");
		out.close();
	}
}
