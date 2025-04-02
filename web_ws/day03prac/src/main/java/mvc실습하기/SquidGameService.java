package mvc실습하기;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SquidGameService {
	String id;
	String pw;
	String name;
	String tel;
	String birth;
	int point;
	String grade;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";
	
	
	public SquidGameService(String id, String pw, String name, String tel, String birth, int point, String grade) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.point = point;
		this.grade = grade;
	}
	public SquidGameService() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SquidGame [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", birth=" + birth
				+ ", point=" + point + ", grade=" + grade + "]";
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getBirth() {
		return birth;
	}
	public int getPoint() {
		return point;
	}
	public String getGrade() {
		return grade;
	}
	
	public ArrayList<SquidGameService> sgList(){
		
		ArrayList<SquidGameService> list = new ArrayList<SquidGameService>();
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "select * from member_tbl_11";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				String birth = rs.getString(5);
				int point = rs.getInt(6);
				String grade = rs.getString(7);
				
				SquidGameService sg = new SquidGameService(id, pw, name, tel, birth, point, grade);
				
				list.add(sg);
				
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<SquidGameService> searchId(String sID){
		
		
		
		ArrayList<SquidGameService> list = new ArrayList<SquidGameService>();
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "select * from member_tbl_11 where id='"+sID+"'";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				String birth = rs.getString(5);
				int point = rs.getInt(6);
				String grade = rs.getString(7);
				
				SquidGameService sg = new SquidGameService(id, pw, name, tel, birth, point, grade);
				
				list.add(sg);
				
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
