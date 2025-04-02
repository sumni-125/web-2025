package 발표;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/3단")
public class 문제2_김유민 extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //resp.setContentType("text/plain; charset=UTF-8");

        
        String total = "";
        for (int i = 1; i < 10; i++) {
            total += "3 × " + i + " = " + (3 * i) + "<br>";
        }

        
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>3단</h1>");
        out.println("<p>" + total + "</p>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
