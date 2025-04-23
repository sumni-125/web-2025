package branches;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ReviewDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String password = "1234";

	public Connection dbCon() {

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			if (con != null)
				System.out.println("db ok~~");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
	
	private void commitLetsgo() {
	      Connection con = dbCon();
	      String sql = "commit";
	      
	      try {
	         PreparedStatement pst = con.prepareStatement(sql);
	         pst.execute();
	         System.out.println("commit ok");
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	
	public ArrayList<Reviews> allReviews(String b_code){
		ArrayList<Reviews> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "select * from Reviews where id = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, b_code);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
			    String r_code = rs.getString(1);
			    String id = rs.getString(2);
			    String title = rs.getString(3);
			    String detail = rs.getString(4);
			    Date r_date_ = rs.getDate(6);

			    if (rs.getString(5) != null) {
			        String answer = rs.getString(5);
			        list.add(new Reviews(r_code, id, title, detail, answer, r_date_));
			    } else {
			        list.add(new Reviews(r_code, id, title, detail, r_date_));
			    }
			}
			con.close();
			pst.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean InsertReview(String id, String title, String detail) {
		
		Connection con = null;
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "INSERT INTO reviews (id,title,detail) "
				+ "VALUES (?,?,?)";
		con = dbCon();
		
		try {			
			con.setAutoCommit(false);
			
			
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, title);
			pst.setString(3, detail);			
			
			int rowsAffected = pst.executeUpdate();
			if(rowsAffected > 0) {
				con.commit();
				result = true;
			}
		} catch (SQLException e) {
			try{
				if(con != null) con.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				if (pst != null)con.close();
				if (pst != null)pst.close();	
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	
	public static void main(String[] args) {
		ReviewDAO a = new ReviewDAO();
		ArrayList<Reviews> list = a.allReviews("B2222");
		for(Reviews b : list) {
			System.out.println(b);
		
		}
	}
	
	
	
}
