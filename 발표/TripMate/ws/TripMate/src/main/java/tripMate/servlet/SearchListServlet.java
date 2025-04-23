package tripMate.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripMate.model.LocationHotelDTO;
import tripMate.model.LocationInfoDTO;
import tripMate.model.SearchDTO;
import tripMate.service.SearchService;

@WebServlet("/list")
public class SearchListServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

        String keyword = req.getParameter("id");

        // Service 사용
        SearchService service = new SearchService();

        SearchDTO dto = service.getOneLocation(keyword);

        List<SearchDTO> list = new ArrayList<>();
        List<LocationInfoDTO> list2 = new ArrayList<>();
        List<LocationHotelDTO> list3 = new ArrayList<>();

        if (dto != null) {
            list.add(dto);
            String location = dto.getLocation();

            // 장소 정보, 호텔 정보 가져오기
            list2 = service.getLocListByLocationName(location);
            list3 = service.getHotelListByLocationName(location);
        }

        req.setAttribute("list", list);
        req.setAttribute("lite", list2);
        req.setAttribute("hotel", list3);

        req.getRequestDispatcher("WEB-INF/views/searchList.jsp").forward(req, resp);
		}

}
