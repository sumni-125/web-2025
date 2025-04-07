package game_item;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ItemListServlet")
public class ItemListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");

        if ("CAT001".equals(categoryId)) { // 무기 카테고리 선택 시
            resp.sendRedirect("WeaponListServlet");
        } else if ("CAT002".equals(categoryId)) { // 무기 카테고리 선택 시
            resp.sendRedirect("ArmourListServlet");
        } else if ("CAT003".equals(categoryId)) { // 무기 카테고리 선택 시
            resp.sendRedirect("MiscItemListServlet");
        } else {
            resp.getWriter().write("현재 지원하지 않는 카테고리입니다.");
        }
    }
}
