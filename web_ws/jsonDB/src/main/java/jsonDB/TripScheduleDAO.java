package jsonDB;

import java.io.Reader;


/*
 
desc  trip_schedule;
drop  table  trip_schedule;
CREATE TABLE trip_schedule (
    ID            NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    TRIP_NAME     VARCHAR2(100),
    SCHEDULE_DATA CLOB,
    CREATED_AT    TIMESTAMP(6)  default sysdate
);



 
 */
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TripScheduleDAO {

    public static Connection getConnection() throws Exception {
        String url = "jdbc:oracle:thin:@localhost:1521:testdb";  // 오라클 주소
        String username = "scott";                      // 오라클 아이디
        String password = "tiger";                  // 오라클 비밀번호

        Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(url, username, password);
    } 


    public static void save0 (TripSchedule0 schedule) {
        try (Connection conn = TripScheduleDAO.getConnection()) {
            String sql = "INSERT INTO trip_schedule (trip_name, schedule_data) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
              
                
                // Jackson으로 JSON 문자열로 변환
                ObjectMapper mapper = new ObjectMapper();
                String jsonString = mapper.writeValueAsString(schedule);
                
                
                pstmt.setString(1, schedule.getDestination() + " 여행");
                System.out.println("jsonString="+ jsonString);
                pstmt.setString(2, jsonString);  // 

                int rows = pstmt.executeUpdate();
                System.out.println(rows + "개 저장 완료.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    //위도, 경도 정보 있는 여행일정
    public static void save (TripSchedule schedule) {
        try (Connection conn = TripScheduleDAO.getConnection()) {
            String sql = "INSERT INTO trip_schedule (trip_name, schedule_data) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
              
                
                // Jackson으로 JSON 문자열로 변환
                ObjectMapper mapper = new ObjectMapper();
                String jsonString = mapper.writeValueAsString(schedule);
                
                
                pstmt.setString(1, schedule.getDestination() + " 여행");
                System.out.println("jsonString="+ jsonString);
                pstmt.setString(2, jsonString);  // 

                int rows = pstmt.executeUpdate();
                System.out.println(rows + "개 저장 완료.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static TripSchedule getScheduleById(Connection conn, int id) throws Exception {
        String sql = "SELECT schedule_data FROM trip_schedule WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Clob clob = rs.getClob("schedule_data");
                    String json = clobToString(clob);

                    System.out.println("읽은 JSON 데이터: " + json); // 디버그용 출력

                    ObjectMapper mapper = new ObjectMapper();
                 return mapper.readValue(json, TripSchedule.class);
                   
                }
        }
        return null;
    }
    }

    private static String clobToString(Clob clob) throws Exception {
        StringBuilder sb = new StringBuilder();
        try (Reader reader = clob.getCharacterStream()) {
            char[] buffer = new char[2048];
            int bytesRead;
            while ((bytesRead = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, bytesRead);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            TripSchedule schedule = getScheduleById(conn, 1);  // id=1인 여행일정 가져오기
            System.out.println(schedule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
