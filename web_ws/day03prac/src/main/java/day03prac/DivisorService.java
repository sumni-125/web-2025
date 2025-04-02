package day03prac;

import java.util.ArrayList;

public class DivisorService {
	public ArrayList<Integer> getDivisor(int su) {

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 1; i <= su; i++) {
			if (su % i == 0) {
				list.add(i);
			}
		}

		return list;
	}

}
