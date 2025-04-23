package branches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class B_I_OrderDAO {

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

	public void insertIORder(B_I_Order i) {
		Connection con = dbcon();
		PreparedStatement pst = null;

		String sql = "insert into B_I_Order (B_CODE, I_CODE, I_CNT) VALUES (?,?,?)";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, i.getB_Code());
			pst.setString(2, i.getI_Code());
			pst.setInt(3, i.getI_Cnt());

			pst.executeUpdate();

			con.close();
			pst.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<B_I_Order> selectOrders(String B_Code) {
		commitLetsfo();
		ArrayList<B_I_Order> list = new ArrayList<>();
		Connection con = dbcon();
		String sql = "SELECT bio.b_i_code, bio.b_i_date, bio.B_CODE, h.H_I_NAME, bio.I_CODE, bio.I_CNT "
				+ "FROM B_I_ORDER bio " + "JOIN HUB h " + "ON h.H_I_CODE = bio.I_CODE " + "where b_code=?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, B_Code);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String B_I_Code = rs.getString(1);
				String B_I_Date = rs.getString(2);
				String b_code = rs.getString(3);
				String i_name = rs.getString(4);
				String i_code = rs.getString(5);
				String cnt_ = rs.getString(6);
				int cnt = Integer.parseInt(cnt_);

				list.add(new B_I_Order(B_I_Code, B_I_Date, b_code, i_code, i_name, cnt));

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

	private void commitLetsfo() {
		Connection con = dbcon();
		String sql = "commit";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		B_I_OrderDAO a = new B_I_OrderDAO();
		// B_I_Order b = new B_I_Order("B4444", "I003", 4);

		// a.insertIORder(b);
		System.out.println(a.selectOrders("B2222"));

	}

}
