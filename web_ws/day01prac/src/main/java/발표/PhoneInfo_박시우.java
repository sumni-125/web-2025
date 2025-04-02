package 발표;

// Phone 객체를 표현하는 내부 클래스
class PhoneInfo_박시우 {  //클래스 이름이랑 다르게 가야한다
    String name;
    int version;
    int price;
    boolean released;

    public PhoneInfo_박시우(String name, int version, int price, boolean released) {
        this.name = name;
        this.version = version;
        this.price = price;
        this.released = released;
    }

    public String getInfo() {
        return "모델명: " + name + "<br>" +
               "버전: " + version + "<br>" +
               "가격: " + price + "원<br>" +
               "출시 여부: " + (released ? "출시됨" : "미출시") + "<br>";
    }
}