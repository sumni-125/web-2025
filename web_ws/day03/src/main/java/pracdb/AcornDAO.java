package pracdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcornDAO {
	
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";	
	

	
	Connection dbcon() {		
		Connection con =null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return con;		
	}
	
	
	
	//에이콘목록가져오기 
	public ArrayList<Acorn>  getAcornList(){
		Connection con  =dbcon();
		PreparedStatement  pst=null;
		ResultSet  rs= null;
		
		String sql ="select * from acorntbl";
		
		ArrayList<Acorn> list = new ArrayList<>();
		try {
			 pst =con.prepareStatement(sql);
			 rs= pst.executeQuery();
			 
			 while( rs.next()) {
				 String id  = rs.getString(1);
				 String pw  = rs.getString(2);
				 String name  = rs.getString(3);
				 Acorn acorn = new Acorn( id, pw, name);
				 list.add(acorn); 
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
	
	public static void main(String[] args) {
		
		AcornDAO  dao = new AcornDAO();
		ArrayList<Acorn> list  =dao.getAcornList();
		
		for( Acorn acorn : list) {
			System.out.println( list);
			
		}
		
	}
	
	

}
