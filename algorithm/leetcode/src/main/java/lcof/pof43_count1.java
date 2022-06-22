package lcof;

public class pof43_count1 {
    public int countDigitOne(int n) {
        int res = 0;
        int sub = 1;
        while (n > 0) {
            if(n % 10 == 1) {
                res+=1;
            }
            n = n /10;
            sub = sub * 10;
        }
        return res;
    }

    public static void main(String[] args) {
        new pof43_count1().countDigitOne(12);
    }
}
