package branches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {

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

	public void insertOrder(String Menu_Code, String Branch_Id, int O_cnt) {
		Connection con = dbcon();
		PreparedStatement pst = null;

		String sql = "insert into B_Order (Menu_Code, Branch_Id, O_cnt) values(?,?,?)";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, Menu_Code);
			pst.setString(2, Branch_Id);
			pst.setInt(3, O_cnt);

			pst.executeUpdate();

			con.close();
			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Order> selectOrder(String Branch_Id) {

		Connection con = dbcon();
		PreparedStatement pst = null;

		ArrayList<Order> olist = new ArrayList<Order>();

		String sql = "SELECT b.O_CODE, MENU_NAME, b.O_CNT, o_date "
				+ "FROM B_ORDER b "
				+ "JOIN MENU m  "
				+ "ON b.MENU_CODE =m.MENU_CODE "
				+ "WHERE BRANCH_ID =?";

		try {

			pst = con.prepareStatement(sql);
			pst.setString(1, Branch_Id);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String O_Code = rs.getString(1);
				String Menu_name = rs.getString(2);
				int O_cnt = Integer.parseInt(rs.getString(3));
				String O_date = rs.getString(4);
				

				Order o = new Order(O_Code, Menu_name, O_cnt, O_date);

				olist.add(o);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return olist;
	}

}
