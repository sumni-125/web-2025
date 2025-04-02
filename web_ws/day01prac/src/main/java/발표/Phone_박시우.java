package 발표;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/yourphone")   // URL 패턴은 겹치면 안됨
public class Phone_박시우 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 폰 정보 입력받기
        String name = req.getParameter("name");
        String version_ = req.getParameter("version");
        String price_ = req.getParameter("price");
        String released_ = req.getParameter("released");

        int version = 0;
        int price = 0;
        boolean released = false;

        // 제대로 입력된 경우에만 통과
        try {
            if (version_ != null && !version_.isEmpty()) {
                version = Integer.parseInt(version_);
            }
            if (price_ != null && !price_.isEmpty()) {
                price = Integer.parseInt(price_);
            }
            if (released_ != null && !released_.isEmpty()) {
                released = Boolean.parseBoolean(released_);
            }
        } catch (NumberFormatException e) {
            version = 0;
            price = 0;
            released = false;
        }

        // 이름이 null인 경우 기본값 설정
        if (name == null || name.isEmpty()) {
            name = "알 수 없음";
        }

        // PhoneInfo 객체 생성
        PhoneInfo_박시우 phone = new PhoneInfo_박시우(name, version, price, released);

        // 응답 처리
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<head><title>Phone 정보</title></head>");
        out.print("<body>");
        out.print("<form action='/day01Prac/yourphone' method='get'>");
        out.print("<input type='text' name='name' placeholder='휴대폰 이름'><br>");
        out.print("<input type='text' name='version' placeholder='버전'><br>");
        out.print("<input type='text' name='price' placeholder='가격'><br>");
        out.print("<input type='text' name='released' placeholder='출시 여부 (true/false)'><br>");
        out.print("<input type='submit' value='조회'>");
        out.print("</form>");
        out.print("<h2>입력한 휴대폰 정보</h2>");
        out.print(phone.getInfo());
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
}
