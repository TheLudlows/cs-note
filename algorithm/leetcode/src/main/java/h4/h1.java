package h4;

public class h1 {

    public String convertToBase7(int num) {

        return Long.toString(num, 7);

    }

    public static void main(String[] args) {
        String res = new h1().convertToBase7(100);
        System.out.println(res);
    }
}
