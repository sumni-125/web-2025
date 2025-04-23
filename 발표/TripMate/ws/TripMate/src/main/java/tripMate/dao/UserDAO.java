package tripMate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shared.DAO;
import tripMate.model.User;

public class UserDAO {
	DAO dao = new DAO();

	public String getUser_code(String nickName) {
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT user_code FROM TRIPMATE_USER WHERE nickName = ?";
		String result = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, nickName);
			rs = pst.executeQuery();
			if (rs.next())
				result = rs.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pst, con);
		return result;
	}

	public User checkUser(String id, String pw) {
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TRIPMATE_USER WHERE ID = ? AND PW = ?";
		User user = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			if (rs.next()) {
				String userCode = rs.getString(1);
				String userid = rs.getString(2);
				String userpw = rs.getString(3);
				String nick = rs.getString(4);
				user = new User(userCode, userid, userpw, nick);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pst, con);
		return user;
	}

	public void insertUser(String id, String pw, String nickname) {
		Connection con = dao.dbcon();
		PreparedStatement pst = null;

		String sql = "INSERT INTO TRIPMATE_USER(ID, PW, NICKNAME)  VALUES(?,?,?)";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			pst.setString(3, nickname);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(pst, con);
	}

	public void UpdateUser(User user) {
		Connection con = dao.dbcon();
		PreparedStatement pst = null;

		String sql = "UPDATE TRIPMATE_USER SET ID = ?, PW = ?, NICKNAME = ?";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getId());
			pst.setString(2, user.getPw());
			pst.setString(3, user.getNick());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(pst, con);
	}
	
	// user_code로 nickName 조회
		public String getNicknameByUserCode(String userCode) {
			Connection con = dao.dbcon();
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "SELECT nickname FROM TRIPMATE_USER WHERE user_code = ?";
			String result = null;
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, userCode);
				rs = pst.executeQuery();
				if (rs.next())
					result = rs.getString(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(rs, pst, con);
			return result;
		}

	public void close(AutoCloseable... a) {
		for (AutoCloseable item : a) {
			try {
				item.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
