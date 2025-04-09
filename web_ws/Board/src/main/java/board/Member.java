package board;

public class Member {
	String id;
	String pw;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + "]";
	}

}
