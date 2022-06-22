package lcof;

public class p016_myPow {
    public static double pow(double x, int n) {
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
            System.out.println(x);
            n = n / 2;
        }
        return res * x;
    }

    /**
     * 2 ^ 5 = 2^2 * 2^2 * 2
     */

    public static double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        long m = n;
        if(m < 0) {
            x = 1/x;
            m = -m;
        }
        return p (x, m);
    }
    public static double p(double x, long n) {
        if(n == 1) {
            return x;
        }
        double res = p(x, n / 2);
        if(n % 2 == 0) {
            return res*res;
        } else {
            return res*res*x;
        }
    }

    public static void main(String[] args) {
        double res = pow(1.0f, -2147483648);
        System.out.println(res);
    }
}
