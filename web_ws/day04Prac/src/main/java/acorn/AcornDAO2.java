package acorn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcornDAO2 {

	// 연결정보
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";

	// 데이터베이스연결메서드

	Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	// 조회하기
	public ArrayList<Acorn> selectAll() {
		ArrayList<Acorn> list = new ArrayList<>();

		Connection con = getConnection();
		String sql = "select* from acorntbl";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);

				Acorn acorn = new Acorn(id, pw, name);
				list.add(acorn);
			}

			rs.close();
			pst.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	// 한 개 조회
	public Acorn selectOne(String id) {
		// 디비연결
		Connection con = getConnection();

		Acorn acorn = null;

		String sql = "select * from acorntbl where id = :";

		// sql작성
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String tid = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);

				acorn = new Acorn(tid, pw, name);
			}

			rs.close();
			pst.close();
			con.close();

		} catch (SQLException e) {
			// TODO: handle exception
		}

		// 실해ㅑ애결과 Acorn 객제변환

		return acorn;
	}

	public void insert(Acorn acorn) {
		Connection con = getConnection();

		String sql = "insert into acorntbl(id, pw, name) values";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, acorn.getId());
			pst.setString(2, acorn.getPw());
			pst.setString(3, acorn.getName());

			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (SQLException e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		/*
		 * AcornDAO2 s = new AcornDAO2(); ArrayList<Acorn> list = s.selectAll();
		 * 
		 * for(Acorn acorn:list) { System.out.println(acorn); }
		 */

		AcornDAO2 s = new AcornDAO2();
		Acorn a = s.selectOne("sumni");
		System.out.println(a);
	}
}
