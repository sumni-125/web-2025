package tripMate.model;

public class User {

	private String userCode;
	private String id;
	private String pw;
	private String nick;

	public User(String id, String pw, String nick) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}

	public User(String userCode, String id, String pw, String nick) {
		super();
		this.userCode = userCode;
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", nick=" + nick + "]";
	}

}
