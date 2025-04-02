package day02Prac;

public class Movie {

	private String name; 
	private String runningtime; 
	private String actor;	
	
	public Movie() {
		
	}

	public Movie(String name, String runningtime, String actor) {
		super();
		this.name = name;
		this.runningtime = runningtime;
		this.actor = actor;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", runningtime=" + runningtime + ", actor=" + actor + "]";
	}

	public String getName() {
		return name;
	}

	public String getRunningtime() {
		return runningtime;
	}

	public String getActor() {
		return actor;
	}
		
}
