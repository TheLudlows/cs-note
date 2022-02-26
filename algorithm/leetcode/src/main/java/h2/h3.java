package h2;

public class h3 {
    public int reverse(int x) {
        boolean flag = x < 0;

        x = Math.abs(x);
        long res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x = x /10;
            if(x > Integer.MAX_VALUE) {
                res = 0;
                break;
            }
        }

        if(flag) {
            return (int) -res;
        }else {
            return (int) res;
        }
    }
}
