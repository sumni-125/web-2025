package headquerter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BranchesDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String password = "1234";
	
	private Connection dbCon() {		
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			if( con != null) { System.out.println("db ok");}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public ArrayList<Branches> allBranches(){
		ArrayList<Branches> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "select * from branches where substr(branch_id,0,1) = 'B'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String addr = rs.getString(3);
				String tel = rs.getString(4);				
				
				list.add(new Branches(id,pw,addr,tel)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public ArrayList<Branches> allBranchesnh(){
		ArrayList<Branches> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "select * from branches where substr(branch_id,0,1) = 'B'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String addr = rs.getString(3);
				String tel = rs.getString(4);				
				
				list.add(new Branches(id,pw,addr,tel)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public static void main(String[] args) {
		BranchesDAO b = new BranchesDAO();
		ArrayList<Branches> list = b.allBranches();
		for(Branches a : list) {
			System.out.println(a);
		}
	}
}
