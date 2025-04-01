package day01;

import java.util.ArrayList;


public class MyUtils {	
	
	public String getDivisor( int su) {		
		// 12      ->  1   2   3   4   6   12
		int su_half = su/2;		
		System.out.println( su);
		System.out.println( su_half);	
		
		ArrayList<Integer> nums = new ArrayList<>();
		
		for( int i=1 ; i<=su_half ; i++) {
			 if( su % i  ==0) {
				 nums.add(i);
			 }
		}			
		nums.add(su);			
		String divisors = nums.toString();		
		return divisors;
	}	
	
	
	
	public String getFightingMessage() {		
		return "퐈이야";
	}
	
	
	
	public static void main(String[] args) {
		MyUtils  a= new MyUtils();
		String result  =a.getDivisor(12);
		System.out.println( result);
		
	}

}
