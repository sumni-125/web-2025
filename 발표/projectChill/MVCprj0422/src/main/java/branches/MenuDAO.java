package branches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String password = "1234";

	public Connection dbcon() {

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
	
	public ArrayList<Menu> selectAll(){
		
		ArrayList<Menu> list = new ArrayList<Menu>();
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql="select * from menu";
		
		try {
			
			pst = con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				String Menu_Code = rs.getString(1);
				String Menu_Name = rs.getString(2);
				String Price = rs.getString(3);
				String ingredient_needs = rs.getString(4);
				
				Menu m = new Menu(Menu_Code, Menu_Name, Price, ingredient_needs);
				list.add(m);
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
	
	public Menu selectOne(String menu_code) {
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql="select * from menu where menu_code=?";
		Menu m =null;
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,menu_code);
			
			
			rs=pst.executeQuery();
			
			if(rs.next()) {
				
				String Menu_Code = rs.getString(1);
				String Menu_Name = rs.getString(2);
				String Price = rs.getString(3);
				String ingredient_needs = rs.getString(4);
				
				m= new Menu(Menu_Code, Menu_Name, Price, ingredient_needs);
			}
			
			con.close();
			pst.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return m;
	}
	
}
