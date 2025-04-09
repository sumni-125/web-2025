package cartPrj;

import java.util.ArrayList;
import java.util.Random;

public class GoodsService {
	
	//상품전체가져오기
	public ArrayList<String>  getList(){		
		ArrayList<String>  list = new ArrayList<>();		
		list.add("티셔츠");
		list.add("바지");
		list.add("스커트");
		list.add("코트");
		list.add("반바지");
		return list;		
	}
	
	
	
	//상품코드로 상품정보 가져오기	
	public String getGoods(String  code) {
		Random r = new Random();		
		String[] list = {"바지"  , "티셔츠" , "원피스"};
		int index  = r.nextInt(2);
		return  list[index];
	}

}
