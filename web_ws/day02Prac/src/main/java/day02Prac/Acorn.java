package day02Prac;

public class Acorn {
	String id;
	String pw;
	String name;
	int point;
	
	
	public Acorn() {
		// TODO Auto-generated constructor stub
	}
	
	public Acorn(String id, String pw, String name, int point) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "Acorn [id=" + id + ", pw=" + pw + ", name=" + name + ", point=" + point + "]";
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
	
	public int getPoint() {
		return point;
	}
	
	
}
