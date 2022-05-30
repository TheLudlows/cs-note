package lc;

public class p007_reverse_int {

    // 注意溢出问题
    public int reverse(int x) {
        int res = 0;

        while(x != 0) {
            int  i = x%10;
            x = x/10;

            if(res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10) {
                return 0;
            }

            res = res * 10  + i;
        }
        return res;
    }
}
