package tripMate.dao;

import java.sql.*;
import java.util.ArrayList;

import shared.DAO;

public class PaymentTypeDAO {
	DAO dao = new DAO();

	public ArrayList<String> getAllPaymentTypes() {
		String sql = "SELECT type_code FROM payment_type_tbl";
		ArrayList<String> list = new ArrayList<>();
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("type_code"));
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
