package tripMate.model;

public class Schedule {
	private String sd_code;
	private String name;
	private String start_date;
	private String end_date;
	private String place_name;

	public Schedule(String sd_code, String name, String start_date, String end_date, String place_name) {
		this.sd_code = sd_code;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.place_name = place_name;
	}

	public String getSd_code() {
		return sd_code;
	}

	public String getName() {
		return name;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setSd_code(String sd_code) {
		this.sd_code = sd_code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	@Override
	public String toString() {
		return "Schedule [sd_code=" + sd_code + ", name=" + name + ", start_date=" + start_date + ", end_date="
				+ end_date + ", place_name=" + place_name + "]";
	}

}
