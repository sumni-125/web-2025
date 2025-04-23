package branches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientsDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String password = "1234";

	private Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("db ok");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;

	}

	public ArrayList<Ingredients> selectAll() {

		Connection con = getConnection();
		ArrayList<Ingredients> list = new ArrayList<>();
		String sql = "select * from Ingredients";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String i_code = rs.getString(1);
				String branch_id = rs.getString(2);
				String i_name = rs.getString(3);
				int i_cnt = rs.getInt(4);

				Ingredients ingredients = new Ingredients(i_code, branch_id, i_name, i_cnt);

				list.add(ingredients);

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

	public ArrayList<Ingredients> selectAll(String branch_id) {

		Connection con = getConnection();
		ArrayList<Ingredients> list = new ArrayList<>();
		String sql = "select * from Ingredients where branch_id=?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, branch_id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String i_code = rs.getString(1);
				String branch_Id = rs.getString(2);
				String i_name = rs.getString(3);
				int i_cnt = rs.getInt(4);

				Ingredients ingredients = new Ingredients(i_code, branch_Id, i_name, i_cnt);

				list.add(ingredients);

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

	public static void main(String[] args) {

		IngredientsDAO dao = new IngredientsDAO();

		ArrayList<Ingredients> list = dao.selectAll();

		for (Ingredients ingredients : list) {

			System.out.println(ingredients);

		}

	}

}
