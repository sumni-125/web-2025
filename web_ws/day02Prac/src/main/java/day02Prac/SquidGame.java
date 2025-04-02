package day02Prac;

public class SquidGame {
	String id;
	String pw;
	String name;
	String tel;
	String birth;
	int point;
	String grade;
	public SquidGame(String id, String pw, String name, String tel, String birth, int point, String grade) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.point = point;
		this.grade = grade;
	}
	public SquidGame() {
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
	
	
	
}
