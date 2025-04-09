package day07Prj;

public class Board {
	String id;
	String notice;
	int likecnt=0;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(String id, String notice, int likecnt) {
		super();
		this.id = id;
		this.notice = notice;
		this.likecnt = likecnt;
	}

	public String getId() {
		return id;
	}

	public String getNotice() {
		return notice;
	}

	public int getLikecnt() {
		return likecnt;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", notice=" + notice + ", likecnt=" + likecnt + "]";
	}
	
}
