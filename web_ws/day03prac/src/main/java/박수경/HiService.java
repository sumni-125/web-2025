package 박수경;


public class HiService {
	
	public String hi() {
		System.out.println("Hi");
		
		String str="Hi 🐼🐼";
		return str;
	
	}

	@Override
	public String toString() {
		return "HiService []";
	}
	
	
	
	public static void main(String[] args) {
		
		HiService  s= new HiService();
		String str  =s.hi();
		
		System.out.println( str);
		
		
	}
	
}
