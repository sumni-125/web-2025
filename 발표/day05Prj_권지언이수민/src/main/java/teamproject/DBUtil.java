package teamproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:testdb", "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
