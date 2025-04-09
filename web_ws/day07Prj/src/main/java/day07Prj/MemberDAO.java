package day07Prj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

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
	
	
	public Member selectOne(String id) {

		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		Member member = null;

		try {

			String sql = "select * from memberTBL_  where id=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);

			rs = pst.executeQuery();

			if (rs.next()) {
				String id_ = rs.getString(1);
				String pw = rs.getString(2);
			

				member = new Member(id_, pw);

			}
			rs.close();
			pst.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("아이디가 없다");
		}

		return member;
	}
	
	
	
	public static void main(String[] args) {
		MemberDAO  m = new MemberDAO();
		Member member  =m.selectOne("acorn");
		
		System.out.println( member);
	}
}
