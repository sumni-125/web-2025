package tripMate.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import tripMate.model.Cost;
import shared.DAO;

public class CostDAO {
	DAO dao = new DAO();

	/**
	 * 비용 저장: 트리거 대신 직접 시퀀스로 cost_id를 생성하여 모델에 세팅하고 INSERT 수행
	 */
	public void insertCost(Cost cost) {
		Connection con = dao.dbcon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. 시퀀스를 통해 cost_id 생성
			String costId = null;
			String seqSql = "SELECT 'C' || LPAD(SEQ_COST_ID.NEXTVAL, 5, '0') FROM DUAL";
			pstmt = con.prepareStatement(seqSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				costId = rs.getString(1);
			}
			rs.close();
			pstmt.close();

			// 2. INSERT 문 실행
			String sql = "INSERT INTO cost_tbl (cost_id, trip_code, trip_date, category_code, location, amount, payment_type, payment_method, payer_code) "
					+ "VALUES (?, ?, TO_DATE(?, 'YYYY.MM.DD'), ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, costId);
			pstmt.setString(2, cost.getTripCode());
			pstmt.setString(3, cost.getTripDate());
			pstmt.setString(4, cost.getCategory());
			pstmt.setString(5, cost.getLocation());
			pstmt.setInt(6, cost.getAmount());
			pstmt.setString(7, cost.getPaymentType());
			pstmt.setString(8, cost.getPaymentMethod());
			pstmt.setString(9, cost.getPayerCode());

			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new RuntimeException("Cost INSERT 실패");
			}

			// 3. DTO에 저장된 cost_id 설정
			cost.setCostId(costId);
			System.out.println("[CostDAO] INSERT 성공: costId=" + costId);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Cost INSERT 실패");
		} finally {
			// 리소스 해제: rs는 이미 닫혔지만 중복 호출 방지를 위해 null 체크
			close(rs, pstmt, con);
		}
	}

	/**
	 * 여행 코드로 지출 목록 조회
	 */
	public ArrayList<Cost> getCostsByTrip(String tripCode) {
		String sql = "SELECT c.cost_id, c.trip_code, c.trip_date, c.category_code, c.location, c.amount, c.payment_type, c.payment_method, c.payer_code, u.nickname "
				+ "FROM cost_tbl c " + "JOIN tripmate_user u ON c.payer_code = u.user_code " + "WHERE c.trip_code = ? "
				+ "ORDER BY c.cost_id asc";
		ArrayList<Cost> list = new ArrayList<>();
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, tripCode);
			rs = pst.executeQuery();
			while (rs.next()) {
				Cost c = new Cost();
				c.setCostId(rs.getString("cost_id"));
				c.setTripCode(tripCode);
				Date date = rs.getDate("trip_date");
				String formattedDate = new SimpleDateFormat("yyyy.MM.dd").format(date);
				c.setTripDate(formattedDate);
				c.setCategory(rs.getString("category_code"));
				c.setLocation(rs.getString("location"));
				c.setAmount(rs.getInt("amount"));
				c.setPaymentType(rs.getString("payment_type"));
				c.setPaymentMethod(rs.getString("payment_method"));
				c.setPayerCode(rs.getString("payer_code"));
				c.setPayerNickname(rs.getString("nickname")); // 닉네임 저장
				list.add(c);
				System.out.println("[CostDAO] 가져온 카테고리 = " + c.getCategory());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return list;

	}

	/**
	 * 리소스 해제 헬퍼
	 */
	private void close(AutoCloseable... acs) {
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
