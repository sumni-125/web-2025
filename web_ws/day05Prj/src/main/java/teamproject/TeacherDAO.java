package teamproject;

import java.sql.*;

public class TeacherDAO {

	public boolean login(String id, String pw) {
		String sql = "SELECT COUNT(*) FROM teacher WHERE id=? AND pw=?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Teacher getTeacherById(String id) {
		String sql = "SELECT * FROM teacher WHERE id=?";
		Teacher t = null;

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				t = new Teacher();
				t.setId(rs.getString("id"));
				t.setPw(rs.getString("pw"));
				t.setTeacher_cd(rs.getString("teacher_cd"));
				t.setClass_cd(rs.getString("class_cd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}
