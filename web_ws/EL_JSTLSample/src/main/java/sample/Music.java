package sample;

public class Music {
	
	String title;
	String singer;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}
	
	public Music() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Music [title=" + title + ", singer=" + singer + "]";
	}
	
	
	
	

}
