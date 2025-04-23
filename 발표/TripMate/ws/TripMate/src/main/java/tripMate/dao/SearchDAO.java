package tripMate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tripMate.model.LocationHotelDTO;
import tripMate.model.LocationInfoDTO;
import tripMate.model.SearchDTO;


public class SearchDAO {
	
	
	 String driver = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	    String user = "scott";
	    String password = "tiger";

	// 데이터베이스 연결 매서드
	Connection getConnection() {

		Connection con = null;

		//
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("db연결 완료");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("db연결 실패");
			e.printStackTrace();
		}

		return con;

	}
	
	
	// 전체조회
	public List<SearchDTO> selectAll(){
			
			List<SearchDTO> list = new ArrayList<>();
			Connection con = getConnection();
			String sql = "SELECT * FROM location_info_tbl lit\n"
					+ "JOIN location_img_tbl lmt\n"
					+ "ON lit.LOCATION_ID = lmt.location_id";
			
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs =  pst.executeQuery();
				
				while(rs.next()) {
					
					String id = rs.getString(1);
					String location = rs.getString(2);
					String url_img = rs.getString(3);
					SearchDTO sd = new SearchDTO(id, location, url_img);
					list.add(sd);
				}
				rs.close();
				pst.close();
				con.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	}
	
	
	
	 // 한 개의 지역만 조회
	public SearchDTO oneSelect(String location) {
		
		
		Connection con = getConnection();
		
		SearchDTO sd = null;
		String sql =  "SELECT * FROM location_info_tbl WHERE LOWER(location_name) = LOWER(?)";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, location);
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next()) {
			    String id = rs.getString("location_id");
			    String loc = rs.getString("location_name");
			    sd = new SearchDTO(id, loc);
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sd;
	}

	
	// 지역 이름을 찾아 해당 지역에 상세 페이지의 추천 관광지 출력할 매서드
	public List<LocationInfoDTO> locListByLocationName(String locationName) {
	    List<LocationInfoDTO> list = new ArrayList<>();
	    Connection con = getConnection();
	    String sql = "SELECT * FROM loc_img_info WHERE location_id IN " +
	            "(SELECT location_id FROM location_info_tbl WHERE location_name = ?)";
	    
	    try {
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, locationName);
	        ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            String title = rs.getString(1);
	            String content = rs.getString(2);
	            String img_url = rs.getString(3);
	            String address = rs.getString(4);
	            String location_id = rs.getString(5);
	            LocationInfoDTO lid = new LocationInfoDTO(title, content, img_url, address, location_id);
	            list.add(lid);
	        }
	        rs.close();
	        pst.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
	
	// 위와 마찬가지로 추천 호텔을 출력할 매서드
	public List<LocationHotelDTO> locListByHotelName(String locationName) {
	    List<LocationHotelDTO> hotelList = new ArrayList<>();
	    Connection con = getConnection();
	    String sql = "SELECT * FROM loc_hotel_info WHERE location_id IN " +
	            "(SELECT location_id FROM location_info_tbl WHERE location_name = ?)";
	    
	    try {
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, locationName);
	        ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            String title = rs.getString(1);
	            int rate = rs.getInt(2);
	            int price = rs.getInt(3);
	            String address = rs.getString(4);
	            String img_url = rs.getString(5);
	            String location_id = rs.getString(6);
	            LocationHotelDTO lid = new LocationHotelDTO(title, rate, price, address, img_url, location_id);
	            hotelList.add(lid);
	        }
	        rs.close();
	        pst.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return hotelList;
	}
	

	public static void main(String[] args) {
		
		
		
//		// 한개 조회하기
//		SearchDAO dao = new SearchDAO();
//		List<LocationInfoDTO> lit = dao.locSelectAll();
//		SearchDTO dt = dao.oneSelect("서울");
//		System.out.println(lit);
	}
	
}
