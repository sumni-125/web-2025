package tripMate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shared.DAO;
import tripMate.model.MarkerData;
import tripMate.model.Schedule;
import tripMate.model.User;

public class ScheduleDAO {
	DAO dao = new DAO();

	public Schedule getSchedule(String SD_CODE) {
		Schedule sc = null;
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT SD_CODE, NAME, TO_CHAR(START_DATE, 'YY/MM/DD'), TO_CHAR(END_DATE, 'YY/MM/DD'), PLACE_NAME FROM TRIPMATE_SCHEDULE WHERE SD_CODE = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, SD_CODE);
			rs = pst.executeQuery();
			while (rs.next()) {
				String sd_code = rs.getString(1);
				String name = rs.getString(2);
				String start_date = rs.getString(3);
				String end_date = rs.getString(4);
				String place_name = rs.getString(5);

				sc = new Schedule(sd_code, name, start_date, end_date, place_name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pst, con);
		return sc;
	}

	public ArrayList<Schedule> getScheduleList(User user) {
		ArrayList<Schedule> list = new ArrayList<>();
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TRIPMATE_SCHEDULE WHERE SD_CODE = ( SELECT SD_CODE FROM trip_member_tbl WHERE USER_CODE = ?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getUserCode());
			rs = pst.executeQuery();
			while (rs.next()) {
				String sd_code = rs.getString(1);
				String name = rs.getString(2);
				String start_date = rs.getString(3);
				String end_date = rs.getString(4);
				String place_name = rs.getString(5);

				list.add(new Schedule(sd_code, name, start_date, end_date, place_name));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pst, con);
		return list;
	}

	public ArrayList<MarkerData> getMarker(String sd_code) {
		ArrayList<MarkerData> list = new ArrayList<MarkerData>();
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TRIPMATE_marker_data WHERE SD_CODE = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, sd_code);
			rs = pst.executeQuery();
			while (rs.next()) {
				String markerId = rs.getString(1);
				String day = rs.getString(3);
				String address = rs.getString(4);
				double lat = rs.getDouble(5);
				double lng = rs.getDouble(6);
				int dayOrder = rs.getInt(7);
				String description = rs.getString(8);

				list.add(new MarkerData(markerId, sd_code, day, address, lat, lng, dayOrder, description));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pst, con);
		return list;
	}
	
	public void updateSchedule(Schedule sc) {
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		String sql = "UPDATE INTO TRIPMATE_SCHEDULE SET NAME = ?, START_DATE = ?, END_DATE = ?, PLACE_NAME = ? WHERE SD_CODE = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, sc.getName());
			pst.setString(2, sc.getStart_date());
			pst.setString(3, sc.getEnd_date());
			pst.setString(4, sc.getPlace_name());
			pst.setString(5, sc.getSd_code());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pst, con);
	}

	public void insertSchedule(Schedule sc) {
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		String sql = "INSERT INTO TRIPMATE_SCHEDULE(NAME, START_DATE, END_DATE, PLACE_NAME) VALUES(?, ?, ?, ?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, sc.getName());
			pst.setString(2, sc.getStart_date());
			pst.setString(3, sc.getEnd_date());
			pst.setString(4, sc.getPlace_name());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pst, con);
	}

	public void insertMarker(MarkerData md) {
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		String sql = "insert into TRIPMATE_marker_data(sd_code, days, address, lat, lng, day_order, descriptiontext)\r\n"
				+ " VALUES (?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, md.getSd_code());
			pst.setString(2, md.getDayS());
			pst.setString(3, md.getAddress());
			pst.setDouble(4, md.getLat());
			pst.setDouble(5, md.getLng());
			pst.setInt(6, md.getDayOrder());
			pst.setString(7, md.getDescription());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pst, con);
	}
	
	public void updateMarker(MarkerData md) {
		Connection con = dao.dbcon();
		PreparedStatement pst = null;
		String sql = "UPDATE TRIPMATE_marker_data SET days = ?, address = ?, lat = ?, lng = ?, day_order = ?, descriptionTEXT = ? WHERE SD_CODE = ? and marker_code = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, md.getDayS());
			pst.setString(2, md.getAddress());
			pst.setDouble(3, md.getLat());
			pst.setDouble(4, md.getLng());
			pst.setInt(5, md.getDayOrder());
			pst.setString(6, md.getDescription());
			pst.setString(7, md.getSd_code());
			pst.setString(8, md.getMarkerId());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pst, con);
	}

	// 일정 코드로 단일 일정 조회
	public Schedule getScheduleByCode(String sdCode) {
		String sql = "SELECT SD_CODE, NAME, " + "       TO_CHAR(START_DATE,'YYYY.MM.DD') START_DATE, "
				+ "       TO_CHAR(END_DATE,'YYYY.MM.DD')   END_DATE, " + "       PLACE_NAME "
				+ "  FROM TRIPMATE_SCHEDULE " + " WHERE SD_CODE = ?";
		Schedule s = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dao.dbcon(); // DB 연결
			pst = con.prepareStatement(sql);
			pst.setString(1, sdCode);
			rs = pst.executeQuery();
			if (rs.next()) {
				s = new Schedule(rs.getString("SD_CODE"), rs.getString("NAME"), rs.getString("START_DATE"),
						rs.getString("END_DATE"), rs.getString("PLACE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pst, con); // 리소스 해제
		}
		return s;
	}

	public void close(AutoCloseable... a) {
		for (AutoCloseable item : a) {
			try {
				item.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
