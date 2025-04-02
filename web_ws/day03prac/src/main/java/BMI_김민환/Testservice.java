package BMI_김민환;

public class Testservice {
	public String calcBMI(double weight, double height) {
		String result;
		   double bmi = weight / (height * height);
        if (bmi < 18.5) {
            result = "저체중";
        } else if (bmi < 24.9) {
            result = "정상 체중";
        } else if (bmi < 29.9) {
            result = "과체중";
        } else {
            result = "비만";
        }
        return result;
	}
}
