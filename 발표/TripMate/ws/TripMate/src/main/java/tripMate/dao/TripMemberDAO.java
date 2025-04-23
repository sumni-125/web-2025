package tripMate.dao;

import java.sql.*;
import java.util.ArrayList;

import tripMate.model.TripMember;
import shared.DAO;

public class TripMemberDAO {
	DAO dao = new DAO();

	// 여행 코드로 참여자 목록 조회
	public ArrayList<TripMember> getMembersBySchedule(String sdCode) {
		String sql = "SELECT sd_code, user_code FROM trip_member_tbl WHERE sd_code = ?";
		ArrayList<TripMember> list = new ArrayList<>();
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, sdCode);
			rs = pst.executeQuery();
			while (rs.next()) {
				// 레코드를 DTO에 담아서 리스트에 추가
				TripMember tm = new TripMember();
				tm.setSdCode(rs.getString("sd_code"));
				tm.setUserCode(rs.getString("user_code"));
				list.add(tm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return list;
	}

	public ArrayList<String> getParticipantNicknamesBySchedule(String sdCode) {
		String sql = "SELECT u.nickname FROM trip_member_tbl t JOIN TRIPMATE_USER u ON t.user_code = u.user_code WHERE t.sd_code = ?";
		ArrayList<String> names = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dao.dbcon();
			pst = con.prepareStatement(sql);
			pst.setString(1, sdCode);
			rs = pst.executeQuery();
			while (rs.next()) {
				names.add(rs.getString("nickname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con); // 리소스 해제
		}
		return names;
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
