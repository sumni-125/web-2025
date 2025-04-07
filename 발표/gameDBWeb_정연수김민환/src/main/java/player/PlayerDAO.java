package player;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayerDAO {

	//DB연결
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	public Connection dbcon() {		
		Connection con=null;
		try {
			Class.forName(driver);
			con  =DriverManager.getConnection(url, user, password);
			if( con != null) System.out.println("DB 성공");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;		
	}		
	
	// 플레이어 전체 조회    
    public ArrayList<Player> selectAll() {
        ArrayList<Player> list = new ArrayList<>();
        Connection con = dbcon();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM PLAYER";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
            while (rs.next()) {
                String id = rs.getString("PLAYER_ID");
                String name = rs.getString("PLAYER_NAME");
                int level = rs.getInt("PLAYER_LEVEL");
                int gold = rs.getInt("PLAYER_GOLD");
                int str = rs.getInt("PLAYER_STR");
                int dex = rs.getInt("PLAYER_DEX");
                int num = rs.getInt("PLAYER_INT");
                Date date = rs.getDate("CREATED_DATE");

                Player p = new Player(id, name, level, gold, str, dex, num, date);
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pst, con);
        }
        return list;
    }
    
    // id로 특정플레이어 조회
    public ArrayList<Player> selectByKeyword(String keyword) {
        ArrayList<Player> list = new ArrayList<>();
        Connection con = dbcon();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM PLAYER WHERE PLAYER_ID LIKE ? OR PLAYER_NAME LIKE ?";
        try {
            pst = con.prepareStatement(sql);
            String searchPattern = "%" + keyword + "%";
            pst.setString(1, searchPattern);
            pst.setString(2, searchPattern);

            rs = pst.executeQuery();

            while (rs.next()) {
                String id = rs.getString("PLAYER_ID");
                String name = rs.getString("PLAYER_NAME");
                int level = rs.getInt("PLAYER_LEVEL");
                int gold = rs.getInt("PLAYER_GOLD");
                int str = rs.getInt("PLAYER_STR");
                int dex = rs.getInt("PLAYER_DEX");
                int intel = rs.getInt("PLAYER_INT");
                Date date = rs.getDate("CREATED_DATE");

                Player p = new Player(id, name, level, gold, str, dex, intel, date);
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pst, con);
        }

        return list;
    }
    
    // ID로 특정 플레이어 조회
    public Player selectById(String playerId) {
        Connection con = dbcon();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Player player = null;

        String sql = "SELECT * FROM PLAYER WHERE PLAYER_ID = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, playerId);
            rs = pst.executeQuery();

            if (rs.next()) {
                String id = rs.getString("PLAYER_ID");
                String name = rs.getString("PLAYER_NAME");
                int level = rs.getInt("PLAYER_LEVEL");
                int gold = rs.getInt("PLAYER_GOLD");
                int str = rs.getInt("PLAYER_STR");
                int dex = rs.getInt("PLAYER_DEX");
                int intel = rs.getInt("PLAYER_INT");
                Date date = rs.getDate("CREATED_DATE");

                player = new Player(id, name, level, gold, str, dex, intel, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pst, con);
        }

        return player;
    }
	
	// 플레이어 삭제
	public void deletePlayerById(String playerId) {
        Connection con = dbcon();        
        String sql = "DELETE FROM PLAYER WHERE PLAYER_ID = ?";        
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(sql);         
            pst.setString(1, playerId);
            
            pst.executeUpdate();            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pst, con);
        }        
    }
	
	// 플레이어 정보 수정
	public void updatePlayer(Player player) {
        Connection con = dbcon();
        PreparedStatement pst = null;
        
        String sql = "UPDATE PLAYER SET PLAYER_NAME = ?, PLAYER_LEVEL = ?, " +
                    "PLAYER_GOLD = ?, PLAYER_STR = ?, PLAYER_DEX = ?, " +
                    "PLAYER_INT = ? WHERE PLAYER_ID = ?";
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, player.getPlayerName());
            pst.setInt(2, player.getPlayerLevel());
            pst.setInt(3, player.getPlayerGold());
            pst.setInt(4, player.getPlayerStr());
            pst.setInt(5, player.getPlayerDex());
            pst.setInt(6, player.getPlayerInt());
            pst.setString(7, player.getPlayerId());
            
            pst.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pst, con);
        }
    }
	
	//close 메서드
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
	
}
