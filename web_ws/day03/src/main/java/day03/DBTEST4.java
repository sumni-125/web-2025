package day03;

import java.sql.*;
import java.util.ArrayList;

import day03.mvcAcorn.Acorn;

public class DBTEST4 {

	public static void main(String[] args) {		 
			
		//DB연결정보
		//driver 
		//url
		//사용자 , 비밀번호		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";	
		
		
		ArrayList<Acorn> list  = new ArrayList<>();
			
		
		try {
			//1. 드라이버 로드 (객체생성)
			Class.forName(driver);			
			//2. 데이터베이스 연결
			Connection  con = DriverManager.getConnection(url, user, password);
			
			//3. 문장얻어오기 
		 
			String sql  ="select * from  acorntbl ";
			PreparedStatement  pst =con.prepareStatement(sql);
			 	 
			//4. ? 세팅하기 
			
			//5.실행 ( executeQuery()-조회,  executeUpdate()- 나머지 등록, 변경, 삭제)
			ResultSet  rs =pst.executeQuery();	//!! sql넣으면 안됨 (sql)
			
			//
			while( rs.next()) {				
				//System.out.print( rs.getString(1));
				//System.out.print( rs.getString(2));
				//System.out.println( rs.getString(3));
				String id  =  rs.getString(1);
				String pw  =  rs.getString(2);
				String name  =  rs.getString(3);				
				
				Acorn acorn = new Acorn( id, pw, name);
				list.add(acorn);				
			} 			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
		//// 학생정보 출력		
		for( int i=0 ; i< list.size(); i++ ) {
			System.out.print(  list.get(i).getName());
			System.out.print(  list.get(i).getId());
			System.out.println(  list.get(i).getPw());
		}
		
		
		//
		System.out.println( " ##########################");
		for( Acorn  a : list) {
			System.out.print( a.getName());
			System.out.print( a.getId());
			System.out.println( a.getPw());
		}
		
		

	}

}
