package teamproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";

	public Connection dbcon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public ArrayList<Student> selectAll() {
		ArrayList<Student> list = new ArrayList<>();
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			String sql = "select * from student";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String student_cd = rs.getString(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String class_cd = rs.getString(4);
				String class_no = rs.getString(5);
				String grade = rs.getString(6);
				String name = rs.getString(7);

				Student student = new Student(student_cd, id, pw, class_cd, class_no, grade, name);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con);
		}
		return list;
	}

	public void insertMember(Student newStudent) {
		Connection con = dbcon();
		PreparedStatement pst = null;

		String sql = " insert  into  student(student_cd, id, pw , class_cd, class_no, grade, name)  values(?,?,?,?,?,?,?) ";

		try {
			pst = con.prepareStatement(sql);

			pst.setString(1, newStudent.getStudent_cd());
			pst.setString(2, newStudent.getId());
			pst.setString(3, newStudent.getPw());
			pst.setString(4, newStudent.getClass_cd());
			pst.setString(5, newStudent.getClass_no());
			pst.setString(6, newStudent.getGrade());
			pst.setString(7, newStudent.getName());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pst, con);
	}

	public Student selectOne(String student_cd) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = " select * from student where student_cd =? ";
		Student student = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, student_cd);
			rs = pst.executeQuery();

			if (rs.next()) {
				String tempstudent_cd = rs.getString(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String class_cd = rs.getString(4);
				String class_no = rs.getString(5);
				String grade = rs.getString(6);
				String name = rs.getString(7);
				student = new Student(tempstudent_cd, id, pw, class_cd, class_no, grade, name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pst, con);
		return student;
	}

	public void close(AutoCloseable... a) {
		for (AutoCloseable item : a) {
			try {
				item.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String student_cd) {
		Connection con = dbcon();
		String sql = "DELETE FROM student WHERE student_cd = ?";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, student_cd);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Student s) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "UPDATE student SET id=?, pw=?, class_cd=?, class_no=? ,grade=?, name=? WHERE student_cd=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getId());
			pst.setString(2, s.getPw());
			pst.setString(3, s.getClass_cd());
			pst.setString(4, s.getClass_no());
			pst.setString(5, s.getGrade());
			pst.setString(6, s.getName());
			pst.setString(7, s.getStudent_cd());

			int rows = pst.executeUpdate();
			System.out.println("📝 UPDATE 결과: " + rows + "행 수정됨");

			if (rows == 0) {
				System.out.println("⚠️ student_cd가 일치하는 레코드가 없어 업데이트 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pst, con);
	}

	public void updateWithOriginalCd(Student s, String original_cd) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "UPDATE student SET student_cd=?, id=?, pw=?, class_cd=?, class_no=? ,grade=?, name=? WHERE student_cd=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, s.getStudent_cd());
			pst.setString(2, s.getId());
			pst.setString(3, s.getPw());
			pst.setString(4, s.getClass_cd());
			pst.setString(5, s.getClass_no());
			pst.setString(6, s.getGrade());
			pst.setString(7, s.getName());
			pst.setString(8, original_cd);
			int rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pst, con);
	}

	public boolean login(String id, String pw) {
		String sql = "SELECT COUNT(*) FROM student WHERE id=? AND pw=?";
		try (Connection conn = dbcon(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Student getStudentById(String id) {
		String sql = "SELECT * FROM student WHERE id=?";
		Student s = null;

		try (Connection conn = dbcon(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				s = new Student();
				s.setId(rs.getString("id"));
				s.setPw(rs.getString("pw"));
				s.setStudent_cd(rs.getString("student_cd"));
				s.setClass_cd(rs.getString("class_cd"));
				s.setClass_no(rs.getString("class_no"));
				s.setGrade(rs.getString("grade"));
				s.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
