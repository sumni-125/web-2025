package tripMate.dao;

import java.sql.*;
import java.util.ArrayList;

import shared.DAO;

public class PaymentMethodDAO {
	DAO dao = new DAO();

	public ArrayList<String> getAllPaymentMethods() {
		String sql = "SELECT method_code FROM payment_method_tbl";
		ArrayList<String> list = new ArrayList<>();
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("method_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return list;
	}

	public void close(AutoCloseable... acs) {
		for (AutoCloseable ac : acs) {
			if (ac != null) {
				try {
					ac.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
