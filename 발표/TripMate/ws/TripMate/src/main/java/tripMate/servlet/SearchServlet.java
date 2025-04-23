package tripMate.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripMate.model.SearchDTO;
import tripMate.service.SearchService;

@WebServlet("/mainsearch")
public class SearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			// 지역의 이름 가져오기 (db에 저장된 id(name))
		 	String keyword = req.getParameter("id");
	        SearchService service = new SearchService();

	        // 검색 결과
	        // 새로운 리스트에 담기
	        List<SearchDTO> searchList = new ArrayList<>();
	        SearchDTO dto = service.getOneLocation(keyword);
	        if (dto != null) {
	            searchList.add(dto);
	        }

	        // 전체 지역 목록
	        List<SearchDTO> locationList = service.getSelectAll();

	        // jsp에서 출력하 수 있게 setArrribute로 저장
	        req.setAttribute("list", searchList);
	        // 전체 지역 저장
	        req.setAttribute("locationList", locationList);

	        req.getRequestDispatcher("WEB-INF/views/searchMain.jsp").forward(req, resp);
	}
}
