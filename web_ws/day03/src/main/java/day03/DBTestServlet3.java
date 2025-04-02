package day03;

 

 
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

import day03.mvcAcorn.Acorn;

@WebServlet("/DBTestServlet3")
public class DBTestServlet3 extends HttpServlet {
   
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // DB 연결 정보
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:testdb";
        String user = "scott";
        String password = "tiger";
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();     
       

        ArrayList<Acorn> acornList = new ArrayList<>();
        try {
            // 1. 드라이버 로드 (객체생성)
            Class.forName(driver);

            // 2. 데이터베이스 연결
            Connection con = DriverManager.getConnection(url, user, password);

            // 3. 문장얻어오기 (Statement)
            Statement st = con.createStatement();

            // 4. 쿼리작성
            String sql = "SELECT * FROM acorntbl  ";

            // 5. 실행 (executeQuery())
            ResultSet rs = st.executeQuery(sql);

            // 6. 결과 처리 (ArrayList에 담기)
            while (rs.next()) {
                Acorn acorn = new Acorn(rs.getString(1), rs.getString(2), rs.getString(3));
                acornList.add(acorn);
            }
            // 7. 리소스 해제
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ArrayList 출력
        out.println("<html><body>");
        out.println("<h2>검색 결과</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>비번</th></tr>");

        for (Acorn acorn : acornList) {
            out.println("<tr>");
            out.println("<td>" + acorn.getId() + "</td>");
            out.println("<td>" + acorn.getName() + "</td>");
            out.println("<td>" + acorn.getPw() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
