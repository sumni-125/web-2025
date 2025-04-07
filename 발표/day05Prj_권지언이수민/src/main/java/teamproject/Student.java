package teamproject;

public class Student {

	String student_cd;
	String id;
	String pw;
	String class_cd;
	String class_no;
	String grade;
	String name;

	@Override
	public String toString() {
		return "Student [student_cd=" + student_cd + ", id=" + id + ", pw=" + pw + ", class_cd=" + class_cd
				+ ", class_no=" + class_no + ", grade=" + grade + ", name=" + name + "]";
	}

	public Student(String student_cd, String id, String pw, String class_cd, String class_no, String grade,
			String name) {
		super();
		this.student_cd = student_cd;
		this.id = id;
		this.pw = pw;
		this.class_cd = class_cd;
		this.class_no = class_no;
		this.grade = grade;
		this.name = name;
	}

	public Student() {

	}

	public String getStudent_cd() {
		return student_cd;
	}

	public void setStudent_cd(String student_cd) {
		this.student_cd = student_cd;
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

	public String getClass_no() {
		return class_no;
	}

	public void setClass_no(String class_no) {
		this.class_no = class_no;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
