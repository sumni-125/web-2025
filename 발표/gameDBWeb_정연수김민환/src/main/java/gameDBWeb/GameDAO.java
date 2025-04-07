package gameDBWeb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameDAO {

	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	public Connection dbcon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (con != null)
				System.out.println("db ok");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
	
	// 게임DB 추천 아이템 조회
	public ArrayList<GameWeb> selectRecommend(){
		ArrayList<GameWeb> list = null;
		list = new ArrayList<>();
		// db연결
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT CASE WHEN ARMOUR_SET_EFFECT LIKE '%STR%' THEN '전사'\r\n"
					+ "WHEN ARMOUR_SET_EFFECT LIKE '%DEX%' THEN '도적'\r\n"
					+ "WHEN ARMOUR_SET_EFFECT LIKE '%INT%' THEN '마법사'\r\n"
					+ "ELSE '균형'\r\n"
					+ "END AS CHARACTER_CLASS,\r\n"
					+ "ARMOUR_SET_NAME,\r\n"
					+ "ARMOUR_SET_EFFECT\r\n"
					+ "FROM ARMOUR_SET\r\n"
					+ "ORDER BY CHARACTER_CLASS";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				String character_class = rs.getString(1);
				String armour_set_name = rs.getString(2);
				String armour_set_effect = rs.getString(3);

				GameWeb gameWeb = new GameWeb(character_class, armour_set_name, armour_set_effect);
				list.add(gameWeb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(rs, pst, con);
		return list;
	}
	
	// 게임Db 추천 아이템 전사만 조회
	public ArrayList<GameWeb> selectWarrior() {
		ArrayList<GameWeb> strList = null;
		strList = new ArrayList<>();
		// db연결
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT CASE WHEN ARMOUR_SET_EFFECT LIKE '%STR%' THEN '전사'\r\n"
					+ "END AS CHARACTER_CLASS,\r\n"
					+ "ARMOUR_SET_NAME,\r\n"
					+ "ARMOUR_SET_EFFECT\r\n"
					+ "FROM ARMOUR_SET\r\n"
					+ "WHERE ARMOUR_SET_EFFECT LIKE '%STR%'\r\n"
					+ "ORDER BY CHARACTER_CLASS";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String character_class = rs.getString(1);
				String armour_set_name = rs.getString(2);
				String armour_set_effect = rs.getString(3);

				GameWeb gameWeb = new GameWeb(character_class, armour_set_name, armour_set_effect);
				strList.add(gameWeb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pst, con);
		return strList;
	}
	
	// 게임 db 추천 아이템 도적만 조회
	public ArrayList<GameWeb> selectThief() {
		ArrayList<GameWeb> dexList = null;
		dexList = new ArrayList<>();
		// db연결
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT CASE WHEN ARMOUR_SET_EFFECT LIKE '%DEX%' THEN '도적'\r\n"
					+ "END AS CHARACTER_CLASS,\r\n"
					+ "ARMOUR_SET_NAME,\r\n"
					+ "ARMOUR_SET_EFFECT\r\n"
					+ "FROM ARMOUR_SET\r\n"
					+ "WHERE ARMOUR_SET_EFFECT LIKE '%DEX%'\r\n"
					+ "ORDER BY CHARACTER_CLASS";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String character_class = rs.getString(1);
				String armour_set_name = rs.getString(2);
				String armour_set_effect = rs.getString(3);

				GameWeb gameWeb = new GameWeb(character_class, armour_set_name, armour_set_effect);
				dexList.add(gameWeb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pst, con);
		return dexList;
	}
	
	// 게임 db 추천 아이템 마법사만 조회
	public ArrayList<GameWeb> selectMage() {
		ArrayList<GameWeb> intList = null;
		intList = new ArrayList<>();
		// db연결
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT CASE WHEN ARMOUR_SET_EFFECT LIKE '%INT%' THEN '마법사'\r\n"
					+ "END AS CHARACTER_CLASS,\r\n"
					+ "ARMOUR_SET_NAME,\r\n"
					+ "ARMOUR_SET_EFFECT\r\n"
					+ "FROM ARMOUR_SET\r\n"
					+ "WHERE ARMOUR_SET_EFFECT LIKE '%INT%'\r\n"
					+ "ORDER BY CHARACTER_CLASS";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String character_class = rs.getString(1);
				String armour_set_name = rs.getString(2);
				String armour_set_effect = rs.getString(3);

				GameWeb gameWeb = new GameWeb(character_class, armour_set_name, armour_set_effect);
				intList.add(gameWeb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pst, con);
		return intList;
	}
	
	//회원가입
	public void signUp(GameAccount account) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		
		String sql = "INSERT INTO PLAYER_ACCOUNT (PLAYER_ACCOUNT_ID, PLAYER_ACCOUNT_PWD, PLAYER_NAME) VALUES (?, ?, ?)";
		
		try {
			pst = con.prepareStatement(sql);
			
			pst.setString(1, account.getAccount_id());
			pst.setString(2, account.getAccount_pw());
			pst.setString(3, account.getAccount_name());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(pst, con);
	}
	
	//로그인
	public int login(String id, String pw) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM PLAYER_ACCOUNT WHERE PLAYER_ACCOUNT_ID = ? AND PLAYER_ACCOUNT_PWD = ?";
		int result = 0;
		GameAccount account = null;

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();

			if (rs.next()) {
				if (pw.equals(rs.getString(2))) {
                    String account_id = rs.getString(1);
                    String account_pw = rs.getString(2);
                    String account_name = rs.getString(3);

                    result = 1;
                    account = new GameAccount(account_id, account_pw, account_name);
                } else {
                	result = 0;
                    System.out.println("비밀번호가 틀렸습니다.");
                }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		close(rs, pst, con);
		return result;
	}
	
	public void close( AutoCloseable ...a) {
		for( AutoCloseable  item : a) {
		   try {
			item.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		
	}
	
	
	public static void main(String[] args) {
		GameDAO dao = new GameDAO();
		ArrayList<GameWeb> list = dao.selectRecommend();
		for (GameWeb gameWeb : list) {
			System.out.println(gameWeb);
		}
	}
}
