package lcof2;

public class p20 {
    public static int countSubstrings(String s) {

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += func(s, i, i);
            res += func(s, i, i + 1);
        }
        return res;

    }

    private static int func(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        countSubstrings("abc");
    }
}
