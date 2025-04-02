package mvc_최하은;

public class CalcService {

	public int getAdd(int su1, int su2) {
		
		int add = (su1+su2);
		return add;
		
	}
	
	public int getMinu(int su1, int su2) {
		
		int minu = (su1-su2);
		return minu;
		
	}
	
	public int getMul(int su1, int su2) {
		
		int mul = (su1*su2);
		return mul;
		
	}
	
	public int getDiv(int su1, int su2) {
		
		int div = (su1%su2);
		return div;
		
	}
}
