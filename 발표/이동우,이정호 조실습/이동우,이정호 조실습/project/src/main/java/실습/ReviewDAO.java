package 실습;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	
	Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	//전체 조회
	public ArrayList<Review> selectAll(String sql_){
		ArrayList<Review> list = new ArrayList<>();
		
		Connection con = getConnection();
		String sql = sql_;
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String user = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String rating = rs.getString(5);
				String date = rs.getString(6);
				
				Review review = new Review(id, user, title, content, rating, date);
				list.add(review);
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//한 개 조회
	public Review selectOne(String id) {
		Review review = null;
			
		Connection con = getConnection(); //db 연결
		String sql = "SELECT * FROM REVIEW WHERE REVIEW_ID = ?"; //sql 작성
			
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				String new_id = rs.getString(1);
				String user = rs.getString(5);
				String title = rs.getString(6);
				String content = rs.getString(2);
				String rating = rs.getString(3);
				String date = rs.getString(4);
				
				review = new Review(new_id, user, title, content, rating, date);
			}
				
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return review;
	}
	
	// 리뷰 등록
	public void addReview(Review review) {
	    Connection con = getConnection();
	    
	    // 책 제목으로 BOOK_ID 조회하는 SQL
	    String bookQuery = "SELECT BOOK_ID FROM BOOK WHERE TITLE = ?";
	    
	    // 리뷰 저장 SQL
	    String sql = "INSERT INTO REVIEW(CONTENTS, RATING, USER_ID, BOOK_ID) VALUES (?, ?, ?, ?)";
	    
	    try {
	        // 1. 책 제목을 이용해 BOOK_ID 조회
	        PreparedStatement bookPst = con.prepareStatement(bookQuery);
	        bookPst.setString(1, review.getTitle());
	        ResultSet rs = bookPst.executeQuery();

	        if (rs.next()) {
	            String bookId = rs.getString("BOOK_ID"); // 조회된 BOOK_ID 가져오기
	            
	            // 2. BOOK_ID를 사용하여 리뷰 저장
	            PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, review.getContent()); // 리뷰 내용
	            pst.setString(2, review.getRating());  // 평점
	            pst.setString(3, review.getUser());    // 사용자 ID
	            pst.setString(4, bookId);              // 변환된 BOOK_ID

	            pst.executeUpdate();
	            
	            // 3. 자원 해제
	            pst.close();
	        } else {
	            System.out.println("해당 제목의 책을 찾을 수 없습니다.");
	        }
	        
	        rs.close();
	        bookPst.close();
	        con.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	//변경하기
	public void update(String content, String rating, String id) {
		Connection con = getConnection();
		String sql = "UPDATE REVIEW SET CONTENTS = ?, RATING = ?, REVIEW_DATE = SYSDATE WHERE REVIEW_ID = ?";
			
		try {
			PreparedStatement pst = con.prepareStatement(sql);
				
			pst.setString(1, content); // 새로운 리뷰 내용
		    pst.setString(2, rating); // 새로운 평점
		    pst.setString(3, id); // 새로운 평점
				
			pst.executeUpdate();
				
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String id) {
		Connection con = getConnection();
		String sql = "DELETE FROM REVIEW WHERE REVIEW_ID = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			
			pst.executeUpdate();
			
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ReviewDAO dao = new ReviewDAO();
//		ArrayList<Review> list = dao.selectAll();
//		
//		for(Review review : list) {
//			System.out.println(review);
//		}
		
		Review review = new Review("TEST3", "2", "u001", "채식주의자");
		dao.addReview(review);
		
//		Review review = dao.selectOne("RE0001");
//		System.out.println(review);
		
//		dao.update("나름 재미있었다.", "4", "RE0001");
		
	}
}
