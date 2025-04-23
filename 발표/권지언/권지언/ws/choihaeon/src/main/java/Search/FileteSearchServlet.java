package Search;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Product.ProductDTO;
import Product.filterproductDTO;

@WebServlet("/filterSearch")
public class FileteSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	
    	System.out.println("filter search");
        
        request.setCharacterEncoding("UTF-8");
 
        String category = request.getParameter("category");
     
       
        SearchDAO searchDAO = new SearchDAO();
        ArrayList<filterproductDTO> searchResults = searchDAO.filtersearchProducts( category );
        
        
        request.setAttribute("searchResults", searchResults);
      
        
        // 검색 결과 페이지로 포워드
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/filtersearchResults.jsp");
        dispatcher.forward(request, response);
    }
} 