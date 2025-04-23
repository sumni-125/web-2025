package tripMate.dao;

import java.sql.*;
import java.util.ArrayList;

import shared.DAO;

public class CategoryDAO {
	DAO dao = new DAO();

	// 전체 카테고리 조회
	public ArrayList<String> getAllCategories() {
		String sql = "SELECT category_code FROM category_tbl ORDER BY CASE category_code" + " WHEN '숙박' THEN 1 "
				+ "    WHEN '항공' THEN 2 " + "    WHEN '교통' THEN 3 " + "    WHEN '식사' THEN 4 " + "    WHEN '관광' THEN 5 "
				+ "    WHEN '쇼핑' THEN 6 " + "    WHEN '기타' THEN 7 " + "    ELSE 8 END";
		ArrayList<String> list = new ArrayList<>();
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("category_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return list;
	}

	// 리소스 해제 메소드
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
