package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/*
 
create  table  foodtbl(
    name varchar2(30) , 
    price  varchar2(10)  
);





insert into foodtbl values( '스파게티' , 12000) ;
insert into foodtbl values( '모듬초밥' , 20000) ;
insert into foodtbl values( '수제햄버거세트' ,14000 ) ;
insert into foodtbl values( '볶음밥' , 10000) ;
insert into foodtbl values( '돈까스카레' , 12000) ;
insert into foodtbl values( '갈비탕' ,16000 ) ;
insert into foodtbl values( '피자' , 12000) ;
insert into foodtbl values( '라면' , 5000) ;
insert into foodtbl values( '참지김밥' ,6000 ) ;
insert into foodtbl values( '소고기김밥' , 6500) ;
insert into foodtbl values( '라볶이' , 6000) ;
insert into foodtbl values( '튀김세트' ,6500 ) ;
 
commit;



 */

public class FoodDAO {
	
	  String driver = "oracle.jdbc.driver.OracleDriver" ;
	  String url="jdbc:oracle:thin:@localhost:1521:testdb";
	  String user="scott";
	  String password="tiger";	 
	 
	
	
	public Connection dbcon(){	 
		Connection con =null;
		try {
			Class.forName(driver);
			con  =DriverManager.getConnection(url, user, password);
			if( con != null) System.out.println("ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	
	
	public ArrayList<Food>  getFoodList(){		
		
		 Connection con  =dbcon();		 
		 String sql=" select  * from  foodtbl ";
		 ArrayList<Food> list = new ArrayList<>();
		 
		 try {
			PreparedStatement pst  = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while( rs.next()){				
				 String name=rs.getString(1);
				 String price= rs.getString(2);
				 
				 Food food = new Food( name, price );
				 list.add(food);						 
			   	
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
	
	
	
	

	public static void main(String[] args){
		  FoodDAO f = new FoodDAO();
	//	  f.dbcon();
		  ArrayList<Food> list  = f.getFoodList();	  
		  System.out.println( list);
		  
	}
	
	
}
