package teamproject;

public class Parents {
	private String parent_id;
	private String id;
	private String pw;
	private String student_cd;
	private String tel;

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Parents [parent_id=" + parent_id + ", id=" + id + ", pw=" + pw + ", student_cd=" + student_cd + ", tel="
				+ tel + "]";
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

	public String getStudent_cd() {
		return student_cd;
	}

	public void setStudent_cd(String student_cd) {
		this.student_cd = student_cd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Parents(String parent_id, String student_cd, String id, String pw, String tel) {
		super();
		this.parent_id = parent_id;
		this.student_cd = student_cd;
		this.id = id;
		this.pw = pw;
		this.tel = tel;
	}

	public Parents() {

	}
}
