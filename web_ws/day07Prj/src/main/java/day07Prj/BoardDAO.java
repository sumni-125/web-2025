package day07Prj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {

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

	public ArrayList<Board> selectAll(String teacher_cd) {

		ArrayList<Board> list = new ArrayList<Board>();

		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			String sql = "select * from board";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String notice = rs.getString(2);
				int likecnt = Integer.parseInt(rs.getString(3)) ;
			

				Board n = new Board(id, notice, likecnt);
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

	public Board selectOne(String notice) {

		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		Board board = null;

		try {

			String sql = "select * from board where notice=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, notice);

			rs = pst.executeQuery();

			if (rs.next()) {
				String id = rs.getString(1);
				String notice_ = rs.getString(2);
				int likecnt = Integer.parseInt(rs.getString(3)) ;
			

				board = new Board(id, notice_, likecnt);

			}
			rs.close();
			pst.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return board;
	}

	public void insert(Board board) {
		Connection con = dbcon();

		String sql = "insert into board(id, notice, likecnt) values(?,?,?)";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, board.getId());
			pst.setString(2, board.getNotice());
			pst.setString(3, Integer.toString(board.getLikecnt()) );
		
			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("오류");
		}

	}

	public void update(Board board) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "UPDATE board SET likecnt=? WHERE notice=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, Integer.toString(board.getLikecnt()));
			pst.setString(2, board.getNotice());

			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * public void delete(String notice) { Connection con = dbcon();
	 * PreparedStatement pst = null; String sql =
	 * "delete FROM notices WHERE notices_cd=?"; try { pst =
	 * con.prepareStatement(sql); pst.setString(1, notices_cd);
	 * 
	 * pst.executeUpdate();
	 * 
	 * pst.close(); con.close();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * }
	 */

}
