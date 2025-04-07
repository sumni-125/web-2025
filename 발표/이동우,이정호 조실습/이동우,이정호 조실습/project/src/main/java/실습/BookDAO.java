package 실습;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
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
	public ArrayList<Book> selectAll(){
		ArrayList<Book> list = new ArrayList<>();
		
		Connection con = getConnection();
		String sql = "SELECT * FROM V_BOOKLIST";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String category = rs.getString(4);
				
				Book book = new Book(id, title, author, category);
				list.add(book);
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//카테고리 조회
	public ArrayList<Book> selectCategory(String category) {
		ArrayList<Book> list = new ArrayList<>();
		
		Connection con = getConnection();
		String sql = "SELECT * FROM V_BOOKLIST WHERE CATEGORY_NAME = ?";
		
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, category);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String newCategory = rs.getString(4);
				
				Book book = new Book(id, title, author, newCategory);
				list.add(book);
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Book selectOne(String title) {
		Book book = null;
		
		Connection con = getConnection();
		String sql = "SELECT * FROM V_BOOKLIST WHERE TITLE = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, title);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String newTitle = rs.getString(2);
				String author = rs.getString(3);
				String category = rs.getString(4);
				
				book = new Book(id, newTitle, author, category);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return book;
	}
	

	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
//		ArrayList<Book> list = dao.selectCategory("소설");
//		
//		for(Book book : list) {
//			System.out.println(book);
//		}
		
		Book book = dao.selectOne("채식주의자");
		System.out.println(book);
	}
}
