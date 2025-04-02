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

@WebServlet("/userlist2")
public class UserList2Servlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 만들기
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";
		
		ArrayList<Acorn> list = new ArrayList<Acorn>();
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from acorntbl2";
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) { //한 행씩 읽는다	
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int point = rs.getInt(4);
				
				Acorn acorn = new Acorn(id,pw,name,point);
				list.add(acorn);
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
				+ "table{"
				+ "width: 450px;"
				+ "</style>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		
		out.println("<tr>");
		
		out.println("<td>아이디</td>");
		out.println("<td>비번</td>");
		out.println("<td>이름</td>");
		out.println("<td>포인트</td>");

		
		out.println("</tr>");
		
		for(Acorn a : list) {
			out.println("<tr>");

			out.println("<td>" + a.getId() + "</td>");
			out.println("<td>" + a.getPw() + "</td>");
			out.println("<td>" + a.getName() + "</td>");
			out.println("<td>" + a.getPoint() + "</td>");

			out.println("</tr>");
		}
		
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
}
