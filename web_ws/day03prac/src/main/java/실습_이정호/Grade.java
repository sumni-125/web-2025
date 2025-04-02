package 실습_이정호;

public class Grade {
	public String name;
	public int kor;
	public int eng;
	public int math;
	public double avg;
	
	public Grade(String name, int kor, int math, int eng) {
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		calAvg();
	}
	public Grade() {
		
	}
	
	
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getMath() {
		return math;
	}
	public int getEng() {
		return eng;
	}
	public double getAvg() {
		return avg;
	}
	
	void calAvg() {
		avg = (kor + math + eng) / 3;
	}
}
