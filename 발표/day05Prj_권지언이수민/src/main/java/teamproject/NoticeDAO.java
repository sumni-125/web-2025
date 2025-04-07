package teamproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";

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

	public ArrayList<Notice> selectAll(String teacher_cd) {

		ArrayList<Notice> list = new ArrayList<Notice>();

		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			String sql = "select * from notices where teacher_cd=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, teacher_cd);

			rs = pst.executeQuery();

			while (rs.next()) {
				String notices_cd = rs.getString(1);
				String title = rs.getString(2);
				String notices_description = rs.getString(3);
				String write_date = rs.getString(4);
				String teacher_cdcd = rs.getString(5);// 변수이름중복
				String class_cd = rs.getString(6);

				Notice n = new Notice(notices_cd, title, notices_description, write_date, teacher_cdcd, class_cd);
				list.add(n);
			}
			rs.close();
			pst.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public Notice selectOne(String notices_cd) {

		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		Notice notice = null;

		try {

			String sql = "select * from notices where notices_cd=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, notices_cd);

			rs = pst.executeQuery();

			if (rs.next()) {
				String notices_cdcd = rs.getString(1);// 변수이름중복
				String title = rs.getString(2);
				String notices_description = rs.getString(3);
				String write_date = rs.getString(4);
				String teacher_cd = rs.getString(5);
				String class_cd = rs.getString(6);

				notice = new Notice(notices_cdcd, title, notices_description, write_date, teacher_cd, class_cd);

			}
			rs.close();
			pst.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return notice;
	}

	public void insert(Notice notice) {
		Connection con = dbcon();

		String sql = "insert into notices(notices_cd, title, notices_description, write_date, teacher_cd, class_cd) values(?,?,?,?,?,?)";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, notice.getNotices_cd());
			pst.setString(2, notice.getTitle());
			pst.setString(3, notice.getNotices_description());
			pst.setString(4, notice.getWrite_date());
			pst.setString(5, notice.getTeacher_cd());
			pst.setString(6, notice.getClass_cd());

			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("오류");
		}

	}

	public void update(Notice notice) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "UPDATE notices SET title=?, notices_description=? WHERE notices_cd=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, notice.getTitle());
			pst.setString(2, notice.getNotices_description());
			pst.setString(3, notice.getNotices_cd());

			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(String notices_cd) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "delete FROM notices WHERE notices_cd=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, notices_cd);

			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
