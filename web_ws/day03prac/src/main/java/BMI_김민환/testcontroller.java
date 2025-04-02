package BMI_김민환;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bmi")
public class testcontroller extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	String result = "";
        try {
            double height = Double.parseDouble(request.getParameter("height")) / 100.0; // cm → m 변환
            double weight = Double.parseDouble(request.getParameter("weight"));
         
            Testservice ts = new Testservice();
            result = ts.calcBMI(weight, height);
            
        } catch (NumberFormatException e) {
            request.setAttribute("error", "올바른 숫자를 입력하세요!");
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
