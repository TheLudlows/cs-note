package lc;

public class p0007_reverse {
    public static void main(String[] args) {
        int n = reverse(1230);
        System.out.println(n);
    }

        public static int reverse(int x) {
            if( x == 0) {
                return 0;
            }
            int ret = 0;

            while (x != 0) {
                int tmp = x % 10;
                if( ret < Integer.MIN_VALUE/10 || ret > Integer.MAX_VALUE/ 10) {
                    return 0;
                }
                x = x / 10;
                ret = ret * 10 + tmp;
            }
            return ret;

        }
}
