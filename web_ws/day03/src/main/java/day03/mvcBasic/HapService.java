package day03.mvcBasic;


//이것이 모델이다 
public class HapService {
	
	
	public int getTotalSum() {
		int sum=0;
		for( int i=1; i<=10;i++) {
			sum+=i;
		}
		
		return sum;
	}

}
