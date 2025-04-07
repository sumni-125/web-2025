package library;

import java.sql.*;
import java.util.ArrayList;

public class LibraryDAO {

    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "system";
    String password = "1234";

    // DB 연결 메서드
    Connection getCon() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없음");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("DB 연결 실패");
            e.printStackTrace();
        }
        return con;
    }

    // ✔ 전체 좌석 조회 (좌석O / 좌석X로 변환해서)
    public ArrayList<Library> selectAll() {
        Connection con = getCon();
        ArrayList<Library> list = new ArrayList<>();
        String sql = "SELECT seat_id, seat_position, " +
                     "CASE seat_status " +
                     "WHEN 1 THEN '좌석X' " +
                     "WHEN 0 THEN '좌석O' " +
                     "END AS seat_status " +
                     "FROM library_seat_tbl";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String seat_id = rs.getString("seat_id");
                String seat_position = rs.getString("seat_position");
                String seat_status = rs.getString("seat_status");

                list.add(new Library(seat_id, seat_position, seat_status));
            }

            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✔ 예약 가능한 좌석만 조회 (좌석O인 것들만)
    public ArrayList<Library> selectOne() {
        Connection con = getCon();
        ArrayList<Library> list = new ArrayList<>();
        String sql = "SELECT seat_id, seat_position, " +
                     "CASE seat_status " +
                     "WHEN 1 THEN '좌석X' " +
                     "WHEN 0 THEN '좌석O' " +
                     "END AS seat_status " +
                     "FROM library_seat_tbl WHERE seat_status = 0";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String seat_id = rs.getString("seat_id");
                String seat_position = rs.getString("seat_position");
                String seat_status = rs.getString("seat_status");

                list.add(new Library(seat_id, seat_position, seat_status));
            }

            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✔ 좌석 상태 업데이트 (좌석O → 좌석X)
    public void update(String seat_id) {
        Connection con = getCon();
        String sql = "UPDATE library_seat_tbl SET seat_status = 1 WHERE seat_id = ?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, seat_id);
            pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void cancelSeat(String seat_id) {
        Connection con = getCon();
        
        String sql = "UPDATE library_seat_tbl SET seat_status = 0 WHERE seat_id = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, seat_id);
            
            pst.executeUpdate();
            
            pst.close();
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 테스트용 메인
    public static void main(String[] args) {
        LibraryDAO dao = new LibraryDAO();

        // 테스트: 좌석 업데이트
//        dao.update("st01");

        // 테스트: 전체 좌석 출력
//        ArrayList<Library> list = dao.selectAll();
//        for (Library l : list) {
//            System.out.println(l.getSeat_id() + " - " + l.getSeat_status());
//        }
        
        dao.cancelSeat("st01");
    }
}