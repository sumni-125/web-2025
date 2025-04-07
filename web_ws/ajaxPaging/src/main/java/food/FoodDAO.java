package food;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
	
	
	
	public ArrayList<Food>  getFoodListPaging( int page){		
		
		  int start = (page-1) * 5 +1;
		  int end = page *5;
		
		  
		  
		 Connection con  =dbcon();		 
		 String sql=" select  *  from   (  select  rownum num,  name, price from foodtbl )  where  num  between  ?  and  ?  ";
		 ArrayList<Food> list = new ArrayList<>();
		 
		 try {
			PreparedStatement pst  = con.prepareStatement(sql);
			pst.setInt(1, start);
			pst.setInt(2, end);
			
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
