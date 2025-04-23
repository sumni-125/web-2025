package tripMate.service;

import java.util.List;

import tripMate.dao.SearchDAO;
import tripMate.model.LocationHotelDTO;
import tripMate.model.LocationInfoDTO;
import tripMate.model.SearchDTO;

public class SearchService {

    SearchDAO dao = new SearchDAO();

    // 전체 조회
    public List<SearchDTO> getSelectAll() {
        return dao.selectAll();
    }

    // 한 지역 조회
    public SearchDTO getOneLocation(String locationName) {
        return dao.oneSelect(locationName);
    }

    // 지역 이름을 가져와 조회 (관광지)
    public List<LocationInfoDTO> getLocListByLocationName(String locationName) {
        return dao.locListByLocationName(locationName);
    }
 
    // 지역 이름을 가지고 조회 (호텔)
    public List<LocationHotelDTO> getHotelListByLocationName(String locationName) {
        return dao.locListByHotelName(locationName);
    }

}
