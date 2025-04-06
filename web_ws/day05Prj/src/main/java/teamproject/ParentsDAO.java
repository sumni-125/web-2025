package teamproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParentsDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";

	public Connection dbcon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public ArrayList<Parents> selectAll() {
		ArrayList<Parents> list = new ArrayList<Parents>();
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			String sql = "select * from parents";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String parent_id = rs.getString(1);
				String student_cd = rs.getString(2);
				String id = rs.getString(3);
				String pw = rs.getString(4);
				String tel = rs.getString(5);

				Parents parents = new Parents(parent_id, student_cd, id, pw, tel);
				list.add(parents);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return list;
	}

	public void insertMember(Parents newparents) {
	    Connection con = dbcon();
	    PreparedStatement pst = null;

	    String sql = "INSERT INTO parents(parent_id, student_cd, id, pw, tel) VALUES(?,?,?,?,?)";

	    try {
	        // 🔥 로그 출력
	        System.out.println("📌 [insertMember 호출됨]");
	        System.out.println("parent_id: " + newparents.getParent_id());
	        System.out.println("student_cd: " + newparents.getStudent_cd());
	        System.out.println("id: " + newparents.getId());
	        System.out.println("pw: " + newparents.getPw());
	        System.out.println("tel: " + newparents.getTel());

	        pst = con.prepareStatement(sql);

	        pst.setString(1, newparents.getParent_id());
	        pst.setString(2, newparents.getStudent_cd());
	        pst.setString(3, newparents.getId());
	        pst.setString(4, newparents.getPw());
	        pst.setString(5, newparents.getTel());

	        int result = pst.executeUpdate();

	        System.out.println("✅ INSERT 결과: " + result + "행 추가됨");

	    } catch (SQLException e) {
	        System.out.println("❌ [insertMember SQLException 발생]");
	        e.printStackTrace();
	    } finally {
	        close(pst, con);
	    }
	}


	public Parents selectOne(String parent_id) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from parents where parent_id=?";
		Parents parents = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, parent_id);
			rs = pst.executeQuery();

			if (rs.next()) {
				String tempparent_id = rs.getString(1);
				String student_cd = rs.getString(2);
				String id = rs.getString(3);
				String pw = rs.getString(4);
				String tel = rs.getString(5);
				parents = new Parents(tempparent_id, student_cd, id, pw, tel);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pst, con);
		return parents;
	}

	public void close(AutoCloseable... a) {
		for (AutoCloseable item : a) {
			try {
				item.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String parent_id) {
		Connection con = dbcon();
		String sql = "DELETE FROM parents WHERE parent_id = ?";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, parent_id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Parents p) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "UPDATE parents SET student_cd=?, id=?, pw=?, tel=? WHERE parent_id=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getParent_id());
			pst.setString(2, p.getStudent_cd());
			pst.setString(3, p.getId());
			pst.setString(4, p.getPw());
			pst.setString(5, p.getTel());

			int rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pst, con);
	}

	public void updateWithOriginalCd1(Parents p, String original_cd) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "UPDATE parents SET parent_id=?, student_cd=?, id=?, pw=?, tel=? WHERE parent_id=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getParent_id());
			pst.setString(2, p.getStudent_cd());
			pst.setString(3, p.getId());
			pst.setString(4, p.getPw());
			pst.setString(5, p.getTel());
			pst.setString(6, original_cd);
			int rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pst, con);
	}

	public boolean login(String id, String pw) {
		String sql = "SELECT COUNT(*) FROM parents WHERE id=? AND pw=?";
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

	public Parents getParentsById(String id) {
		String sql = "SELECT * FROM parents WHERE id=?";
		Parents p = null;

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				p = new Parents();
				p.setId(rs.getString("id"));
				p.setPw(rs.getString("pw"));
				p.setParent_id(rs.getString("parent_id"));
				p.setStudent_cd(rs.getString("student_cd"));
				p.setTel(rs.getString("tel"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}