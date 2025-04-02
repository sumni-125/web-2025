package 발표;

public class A_김보성 {

	public String 약수구하기(int num) {
        String result = "";

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) result += i + " ";
        }
        
        return result;
	}
	
}
