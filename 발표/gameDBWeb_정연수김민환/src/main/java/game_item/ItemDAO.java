package game_item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
    String user = "scott";
    String password = "tiger";

    public Connection dbcon() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    //아이템 카테고리
    public ArrayList<ItemCategory> getAllCategories() {
        ArrayList<ItemCategory> list = new ArrayList<>();
        Connection con = dbcon();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM ITEM_CATEGORY";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String id = rs.getString("CATEGORY_ID");
                String name = rs.getString("CATEGORY_NAME");
                
                ItemCategory cat = new ItemCategory(id, name);
                list.add(cat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pst, con);
        }
        return list;
    }
    
    
    //무기 조회
    public ArrayList<Weapon> getAllWeapons() { 
    	ArrayList<Weapon> list = new ArrayList<>();
        Connection con = dbcon();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM WEAPON";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                int atk = rs.getInt(3);
                String type = rs.getString(4);             
                String desc = rs.getString(6);
                int level = rs.getInt(7);
                
                Weapon cat = new Weapon(id, name, atk, type, desc, level);
                list.add(cat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pst, con);
        }
        return list;
    }

    //방어구조회
    public ArrayList<Armour> getAllArmours() { 
    	ArrayList<Armour> list = new ArrayList<>();
        Connection con = dbcon();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM ARMOUR";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                int def = rs.getInt(3);
                String type = rs.getString(4);             
                String slot = rs.getString(6);
                String desc = rs.getString(7);
                int level = rs.getInt(8);
                
                Armour cat = new Armour(id, name, def, type, slot, desc, level);
                list.add(cat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pst, con);
        }
        return list;
    }
    
    //소모품 기타아이템 조회
    public ArrayList<MiscItem> getAllMiscItems() { 
    	ArrayList<MiscItem> list = new ArrayList<>();
        Connection con = dbcon();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM MISC_MASTER_TABLE";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String type = rs.getString(3);             
                String desc = rs.getString(4);
                String stackable = rs.getString(5);
                
                MiscItem cat = new MiscItem(id, name, type, desc, stackable);
                list.add(cat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pst, con);
        }
        return list;
    }

    
    
    //close 매서드
    public void close(AutoCloseable... a) {
        for (AutoCloseable item : a) {
            try {
                item.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*테스트용 메인
    public static void main(String[] args) { 
    	
    	ItemDAO dao = new ItemDAO();
        ArrayList<MiscItem> list = dao.getAllMiscItems();
        
       System.out.println(list);

    }
    */
}
