package mvc실습하기;

import java.util.ArrayList;

public class CuteServer {
	public ArrayList<String> cuteImg() {
		ArrayList<String> list = new ArrayList<>();
		list.add("/day3Prac/images.jpg");
		list.add("/day3Prac/다운로드.jpg");
        return list; 
	}
}
