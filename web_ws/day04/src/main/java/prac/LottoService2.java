package prac;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoService2 {

	
	public int[] getLotto(int su) {
		
		 
		
		Lotto l = new Lotto();
		
		int[] a = l.Make();
		 
		return a;
	}
	
	
	public static void main(String[] args) {
		LottoService2 s = new LottoService2();
		//String result = s.getLotto(5);
		//System.out.println(result);
	}
}

