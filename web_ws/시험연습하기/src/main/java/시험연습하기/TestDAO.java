package 시험연습하기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";

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
	
	public ArrayList<Acorn> selectAll() {
		Connection con = dbcon();
		PreparedStatement pst = null;
		
		ArrayList<Acorn> list = new ArrayList<>();
		try {
			String sql = "select * from acorntbl";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				
				Acorn a = new Acorn(id, pw, name);
				
				list.add(a);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public Acorn selectOne(String inputId) {
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		Acorn a = null;
		
		String sql = "select * from acorntbl where id =?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, inputId);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				
				a = new Acorn(id, pw, name);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	public void deleteOne(String id) {
		
		Connection con = dbcon();
		PreparedStatement pst=null;
		
		String sql = "delete from acorntbl where id =?";
		
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		TestDAO t = new TestDAO();

		/*
		 * ArrayList<Acorn> list = t.selectAll(); 
		 * System.out.println(list);
		 * t.deleteOne("hihihi");
		 * System.out.println(t.selectAll());
		 */
		
	}
	
}

