package day06Prac;

public class StringBuilderTest {

	public static void main(String[] args) {

		// String => 불변객체

		String str = "hello";
		str += "servlet";

		System.out.println(str);

		// 문자열을 많이 추가할때는 => String 대신에 StringBuilder사용함( 성능좋음 )

		StringBuilder strb = new StringBuilder(100);
		strb.append("hello");
		strb.append("servlet");
		strb.append(" 우왕");

		System.out.println(strb.toString());

	}

}
