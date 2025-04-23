package headquerter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String password = "1234";
	
	private Connection dbCon() {		
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			if( con != null) { System.out.println("db ok");}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public ArrayList<Reviews> allReviews(){
		ArrayList<Reviews> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "SELECT r_code, id, title, detail, answer, r_date FROM Reviews";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String r_code = rs.getString(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				String detail = rs.getString(4);				
				String answer = rs.getString(5);
				Date r_date = rs.getDate(6);
				
				list.add(new Reviews(r_code,id,title,detail,answer, r_date)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//얘가 지금 하던거임 04/16버전
	public void writeAnswer(String r_code, String H_answer) {
		if(r_code == null) {
			System.out.println("리뷰 코드 null");
		}
		
		Reviews thatReview = null;
		ArrayList<Reviews> list = allReviews();
		for(Reviews b : list) {
			if(r_code.equals(b.getR_code())) {
				thatReview = b;
			}
		}
		
		Connection con = dbCon();
		String sql = "UPDATE Reviews\r\n"
				+ "SET ANSWER = ? \r\n"
				+ "WHERE R_CODE = ? ";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, H_answer);
			pst.setString(2, thatReview.getR_code());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Reviews> getPagedList(PagingVO paging){
		List<Reviews> pagelist = new ArrayList<>();
		ReviewDAO dao = new ReviewDAO();
		
		String sql = "SELECT * FROM ("
				+ "    SELECT a.*, ROWNUM rn"
				+ "    FROM ("
				+ "        SELECT r_code, id, title, detail, answer, r_date"
				+ "        FROM reviews"
				+ "        ORDER BY r_code ASC"
				+ "    ) a"
				+ "    WHERE ROWNUM <= ?"
				+ ") "
				+ "WHERE rn >= ?";

		
		try (Connection con = dao.dbCon();
			 PreparedStatement pst = con.prepareStatement(sql)){
			
			pst.setInt(1, paging.getLastRow());
			pst.setInt(2, paging.getFirstRow());
			
			try(ResultSet rs = pst.executeQuery()){
				System.out.println("쿼리 실행 완료" + rs.getRow());
				while(rs.next()) {
					Reviews reviews = new Reviews();
					
					reviews.setR_Code(rs.getString(1));
					reviews.setId(rs.getString(2));
					reviews.setTitle(rs.getString(3));
					reviews.setDetail(rs.getString(4));
					reviews.setAnswer(rs.getString(5));
					reviews.setR_Date(rs.getDate(6));
						
					
					pagelist.add(reviews);
					System.out.println(pagelist);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("리뷰 개수: " + pagelist.size());
		System.out.println("firstRow: " + paging.getFirstRow());
		System.out.println("lastRow: " + paging.getLastRow());
		return pagelist;
	}
	
	public int getTotalCount() {
		String sql = "select Count(*) from reviews";
		ReviewDAO dao = new ReviewDAO();
		
		Connection con = dao.dbCon();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		ReviewDAO a = new ReviewDAO();
		ArrayList<Reviews> list = a.allReviews();
		for(Reviews b : list) {
			System.out.println(b);
		}
		a.writeAnswer(null, null);
		String r_code = "R0001";
		a.writeAnswer(r_code, "dkssudgktpdy rkatkgkqsl;ek");

	}
}
