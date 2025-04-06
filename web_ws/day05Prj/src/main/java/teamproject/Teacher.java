package teamproject;

public class Teacher {

	String teacher_cd;
	String id;
	String pw;
	String class_cd;

	public String getTeacher_cd() {
		return teacher_cd;
	}

	public void setTeacher_cd(String teacher_cd) {
		this.teacher_cd = teacher_cd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getClass_cd() {
		return class_cd;
	}

	public void setClass_cd(String class_cd) {
		this.class_cd = class_cd;
	}

	@Override
	public String toString() {
		return "Teacher [teacher_cd=" + teacher_cd + ", id=" + id + ", pw=" + pw + ", class_cd=" + class_cd + "]";
	}

	public Teacher(String teacher_cd, String id, String pw, String class_cd) {
		super();
		this.teacher_cd = teacher_cd;
		this.id = id;
		this.pw = pw;
		this.class_cd = class_cd;
	}

	public Teacher() {

	}
}
