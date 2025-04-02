package day02Prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SquidGame")
public class SquidgameServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터 만들기
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";
		
		ArrayList<SquidGame> list = new ArrayList<SquidGame>();
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "select * from member_tbl_11";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				String birth = rs.getString(5);
				int point = rs.getInt(6);
				String grade = rs.getString(7);
				
				SquidGame sg = new SquidGame(id, pw, name, tel, birth, point, grade);
				
				list.add(sg);
				
				
			}
			System.out.println(list);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		//응답하기
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style> "
				+ "table, tr, td{"
				+ "margin: 0 auto;"
				+ "border: 1px solid black;"
				+ "border-collapse: collapse;"
				+ "}"
				+ "td{"
				+ "width: 100px;"
				+ "height: 30px;"
				+ "}"
				+ "form{"
				+ "width: 300px;"
				+ "margin: 0 auto;"
				+ "padding: 50px;"
				+ "}"
				+ "input{"
				+ "padding: 0px;"
				+ "height: 30px;"
				+ ""
				+ "}"
				+ "button{"
				+ "padding: 0px;"
				+ "height:30px;"
				+ "}"
				+ "</style>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		
		out.println("<tr>");
		
		out.println("<td>아이디</td>");
		out.println("<td>비번</td>");
		out.println("<td>이름</td>");
		out.println("<td>포인트</td>");
		out.println("<td>생년월일</td>");
		out.println("<td>전화번호</td>");
		out.println("<td>등급</td>");
		
		out.println("</tr>");
		
		for(SquidGame sg : list) {
			out.println("<tr>");

			out.println("<td>" + sg.getId() + "</td>");
			out.println("<td>" + sg.getPw() + "</td>");
			out.println("<td>" + sg.getName() + "</td>");
			out.println("<td>" + sg.getPoint() + "</td>");
			out.println("<td>" + sg.getBirth() + "</td>");
			out.println("<td>" + sg.getTel() + "</td>");
			out.println("<td>" + sg.getGrade() + "</td>");

			out.println("</tr>");
		}
		
		
		out.println("</table>");
//		out.println("<form method=submit>");
//		out.println("<input type=text placeholder=\"아이디를 입력하세요\">");
//		out.println("<button type=\"submit\">아이디 조회하기</button>");
//		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
	}
}
