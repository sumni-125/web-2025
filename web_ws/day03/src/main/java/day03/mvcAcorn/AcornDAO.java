package day03.mvcAcorn;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AcornDAO {
    
    // DB 연결 정보
    private String url = "jdbc:oracle:thin:@localhost:1521:testdb";
    private String user = "scott";
    private String password = "tiger";

    // DB 연결 메서드 (드라이버 로드 및 DB 연결)
    private Connection dbCon() throws SQLException {
    	Connection con = null;
        try {
            // 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // DB 연결 객체 반환
        return con;
    }

    // 전체 레코드 조회
    public ArrayList<Acorn> getAllAcorns() {
        ArrayList<Acorn> acornList = new ArrayList<>();
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // DB 연결 (dbCon 메서드를 통해 연결)
            con = dbCon();
            
            // SQL 문장 생성
            st = con.createStatement();

            // SQL 쿼리 작성
            String sql = "SELECT * FROM acorntbl";

            // 쿼리 실행
            rs = st.executeQuery(sql);

            // 결과 처리
            while (rs.next()) {
                Acorn acorn = new Acorn(rs.getString(1), rs.getString(2), rs.getString(3));
                acornList.add(acorn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 리소스 해제
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return acornList;
    }
    
    
    
    
}
