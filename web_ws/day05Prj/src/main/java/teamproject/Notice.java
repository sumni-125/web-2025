package teamproject;

public class Notice {
	/*
	 * CREATE TABLE notices ( 
	 * notices_cd VARCHAR2(20) PRIMARY KEY, 
	 * title VARCHAR2(100) NOT NULL, 
	 * notices_description VARCHAR2(999), 
	 * write_date DATE DEFAULT SYSDATE, 
	 * teacher_cd VARCHAR2(4), 
	 * class_cd VARCHAR2(4),
	 */
	
	String notices_cd;
	String title;
	String notices_description;
	String write_date;
	String teacher_cd;
	String class_cd;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(String notices_cd, String title, String notices_description, String write_date, String teacher_cd,
			String class_cd) {
		super();
		this.notices_cd = notices_cd;
		this.title = title;
		this.notices_description = notices_description;
		this.write_date = write_date;
		this.teacher_cd = teacher_cd;
		this.class_cd = class_cd;
	}

	public String getNotices_cd() {
		return notices_cd;
	}

	public String getTitle() {
		return title;
	}

	public String getNotices_description() {
		return notices_description;
	}

	public String getWrite_date() {
		return write_date;
	}

	public String getTeacher_cd() {
		return teacher_cd;
	}

	public String getClass_cd() {
		return class_cd;
	}

	@Override
	public String toString() {
		return "Notice [notices_cd=" + notices_cd + ", title=" + title + ", notices_description=" + notices_description
				+ ", write_date=" + write_date + ", teacher_cd=" + teacher_cd + ", class_cd=" + class_cd + "]";
	}
	
	
	
	
} 
