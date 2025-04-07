package restApi;


// 문자열을 연결할 때는 String보다 StringBuilder가 효과적이다  

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("Hello");
        sb.append(" ");
        sb.append("World!");

        System.out.println(sb.toString());  // 출력: Hello World!
    }
}
