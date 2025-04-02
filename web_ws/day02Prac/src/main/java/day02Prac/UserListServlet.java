package day02Prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//회원정보 응답하기
@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//데이터베이스 연동
		//원하는 형식으로 가공해서 응답
		
		//
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";
		
		//1. 오라클 드라이버 로딩
		try {
			
		
		Class.forName(driver);
		
		//2. 데이터베이스 연결
		
		con = DriverManager.getConnection(url, user, password);
		
		//3. sql 작성하기
		
		String sql ="select * from acorntbl2";
		
		//4. Statement 객체 얻어오기(쿼리 실행명령 가지고있음)
		
		st = con.createStatement();
		
		rs = st.executeQuery(sql);
		
		//5. ResultSet 객체 얻어오기(쿼리 실행결과, select 쿼리결과)
		
		while(rs.next()) {
			
			out.print(rs.getString(1)+" ");
			out.print(rs.getString(2)+" ");
			out.print(rs.getString(3)+" ");
			out.println(rs.getString(4)+"<br>");
			
		}
		rs.close();
		st.close();
		con.close();
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
	}
}
