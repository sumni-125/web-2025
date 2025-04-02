package day03;

import java.sql.*;

public class DBTEST3 {

	public static void main(String[] args) {		 
			
		//DB연결정보
		//driver 
		//url
		//사용자 , 비밀번호		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";	
		
				
		try {
			//1. 드라이버 로드 (객체생성)
			Class.forName(driver);			
			//2. 데이터베이스 연결
			Connection  con = DriverManager.getConnection(url, user, password);
			
			//3. 문장얻어오기 ( PreparedStatement)
			String name ="최하은"; 
			String sql  ="select * from  acorntbl where name  = ?";
			PreparedStatement  pst =con.prepareStatement(sql);
			pst.setString(1, name);	 //왼쪽 물음표부터 	 
			
			//5.실행 ( executeQuery()-조회,  executeUpdate()- 나머지 등록, 변경, 삭제)
			ResultSet  rs =pst.executeQuery();	
			
			//
			while( rs.next()) {				
				System.out.print( rs.getString(1));
				System.out.print( rs.getString(2));
				System.out.println( rs.getString(3));
			} 			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
