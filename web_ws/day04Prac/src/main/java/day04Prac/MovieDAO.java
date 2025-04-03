package day04Prac;

import java.sql.*;
import java.util.ArrayList;

public class MovieDAO {
	
		//url
		//사용자 , 비밀번호		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";
		
		
		
		//
		
		
		Connection  dbCon() {			
			
			Connection con = null;
		
			try {
				
				//1.
				Class.forName(driver);
				//2.
				con = DriverManager.getConnection(url, user, password);				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
		
		
		
		//
		public ArrayList<Movie> selectAll(){
			 
			Connection con  = dbCon();
			PreparedStatement   pst = null;
			ResultSet  rs = null;
			
			ArrayList<Movie> list  = new ArrayList<>();
			String sql = "select  * from  movietbl  " ;
			try {
				pst =con.prepareStatement(sql);
				rs=pst.executeQuery();
				
				while( rs.next()) {   //  한 행 (레코드)
					String id = rs.getString(1);
					String title = rs.getString(2);
					String url  = rs.getString(3);
					String genre = rs.getString(4);
					
					//
					Movie m  = new Movie( id, title, url, genre);
					list.add(m);
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
			/*
			ArrayList<Movie> list = new ArrayList<>();
			
			list.add( new Movie( "m001" , "반지의 제왕" , "https://m.media-amazon.com/images/I/51Qvs9i5a%2BL._AC_.jpg" ,"SF"));
			list.add( new Movie( "m002" , "매트릭스 " ,"https://m.media-amazon.com/images/I/51EG732BV3L._AC_.jpg" ,"SF"));
			list.add( new Movie( "m003", "인터스텔라", "https://m.media-amazon.com/images/I/A1JVqNMI7UL._AC_SY679_.jpg" ,"SF"));
			*/
			
			return list;
			
		}
		
		
		public static void main(String[] args) {
			
			MovieDAO m = new MovieDAO();
			ArrayList <Movie>  list  =m.selectAll();
			
			System.out.println( list);
			
		}
		

}


/*
 
  CREATE TABLE movietbl (
    id VARCHAR2(10) PRIMARY KEY,
    title VARCHAR2(100) NOT NULL,
    image_url VARCHAR2(500),
    genre VARCHAR2(50)
);



INSERT INTO movietbl (id, title, image_url, genre) VALUES ('m001', '반지의 제왕', 'https://m.media-amazon.com/images/I/51Qvs9i5a%2BL._AC_.jpg', 'SF');
INSERT INTO movietbl (id, title, image_url, genre) VALUES ('m002', '매트릭스', 'https://m.media-amazon.com/images/I/51EG732BV3L._AC_.jpg', 'SF');
INSERT INTO movietbl (id, title, image_url, genre) VALUES ('m003', '인터스텔라', 'https://m.media-amazon.com/images/I/A1JVqNMI7UL._AC_SY679_.jpg', 'SF');


commit;


 */
