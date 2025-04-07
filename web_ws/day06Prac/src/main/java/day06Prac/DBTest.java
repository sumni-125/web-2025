package day06Prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DBTest {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:testdb"; // Oracle 접속 URL
        String user = "scott";
        String password = "tiger";

        String inputName = "홍길동";
        String inputDateStr = "1990-01-15"; // 문자열로 입력 받은 날짜

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO users (id, name, birth_date) VALUES (users_seq.NEXTVAL, ?, ?)"
            )
        ) {
            pstmt.setString(1, inputName);

            // 문자열을 java.sql.Date로 변환
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(inputDateStr);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            pstmt.setDate(2, sqlDate);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + "행이 삽입되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
