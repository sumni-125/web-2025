// File: tripMate/dao/PersonalCostDAO.java
package tripMate.dao;

import java.sql.*;
import java.util.ArrayList;

import tripMate.model.PersonalCost;
import shared.DAO;

public class PersonalCostDAO {
	DAO dao = new DAO();

	// 개인 비용 저장 (userCode를 String으로 변경)
	public void insertPersonalCost(PersonalCost pc) {
		Connection con = dao.dbcon();
		PreparedStatement seqPst = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			// 1) 시퀀스에서 nextval 뽑아서 personal_cost_id 생성
			String seqSql = "SELECT 'P' || LPAD(SEQ_PERSONAL_COST_ID.NEXTVAL, 5, '0') FROM DUAL";
			seqPst = con.prepareStatement(seqSql);
			rs = seqPst.executeQuery();
			if (rs.next()) {
				pc.setPersonalCostId(rs.getString(1)); // 모델에 ID 세팅
			}
			rs.close();
			seqPst.close();

			// 2) INSERT (personal_cost_id 포함)
			String sql = "INSERT INTO personal_cost_tbl "
					+ "(personal_cost_id, cost_id, user_code, personal_cost, status) " + "VALUES (?, ?, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, pc.getPersonalCostId());
			pst.setString(2, pc.getCostId());
			pst.setString(3, pc.getUserCode());
			pst.setInt(4, pc.getPersonCost());
			pst.setString(5, pc.getStatus());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("PersonalCost INSERT 실패", e);
		} finally {
			// 리소스 해제
			close(rs, seqPst, pst, con);
		}
	}

	// 정산 상태 업데이트 메서드
	public void updateStatus(String personalCostId, String newStatus) {
		Connection con = dao.dbcon();
		PreparedStatement pst = null;

		try {
			String sql = "UPDATE personal_cost_tbl SET status = ? WHERE personal_cost_id = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, newStatus);
			pst.setString(2, personalCostId);
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println("[PersonalCostDAO] 상태 업데이트 성공: " + personalCostId + " → " + newStatus);
			} else {
				System.out.println("[PersonalCostDAO] 상태 업데이트 실패: ID = " + personalCostId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pst, con);
		}
	}

	// 여행 코드로 개인 비용 목록 조회 (tripCode를 String으로 변경)
	public ArrayList<PersonalCost> getPersonalCostsByTrip(String tripCode) {
		String sql = "SELECT pc.personal_cost_id, pc.cost_id, pc.user_code, pc.personal_cost, pc.status, c.payer_code "
				+ "FROM personal_cost_tbl pc JOIN cost_tbl c ON pc.cost_id = c.cost_id WHERE c.trip_code = ?";
		ArrayList<PersonalCost> list = new ArrayList<>();
		try (Connection con = dao.dbcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, tripCode); // String으로 변경
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					PersonalCost p = new PersonalCost();
					p.setPersonalCostId(rs.getString("personal_cost_id"));
					p.setCostId(rs.getString("cost_id"));
					p.setUserCode(rs.getString("user_code")); // String
					p.setPersonCost(rs.getInt("personal_cost"));
					p.setStatus(rs.getString("status"));
					p.setPayer(rs.getString("payer_code"));
					list.add(p);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	// 리소스 해제
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
