package day02Prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";

		// 1. 오라클 드라이버 로딩

		Class.forName(driver);

		// 2. 데이터베이스 연결

		con = DriverManager.getConnection(url, user, password);

		// 3. sql 작성하기

		String sql = "select * from acorntbl2";

		// 4. Statement 객체 얻어오기(쿼리 실행명령 가지고있음)

		st = con.createStatement();

		rs = st.executeQuery(sql);

		// 5. ResultSet 객체 얻어오기(쿼리 실행결과, select 쿼리결과)

		while (rs.next()) {

			System.out.print(rs.getString(1) + " ");
			System.out.print(rs.getString(2) + " ");
			System.out.print(rs.getString(3) + " ");
			System.out.println(rs.getString(4));

		}
		rs.close();
		st.close();
		con.close();

	}

}
