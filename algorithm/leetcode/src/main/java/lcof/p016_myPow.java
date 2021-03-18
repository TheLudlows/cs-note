package lcof;

public class p016_myPow {
    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1;
        while (n != 1) {
            if (n % 2 == 1) {
                res *= x;
            }
            x = x * x;
            n = n / 2;
        }
        System.out.println(x + " " + res);
        return res * x;
    }


    public static void main(String[] args) {
        myPow(2.0f,19);
    }

}
