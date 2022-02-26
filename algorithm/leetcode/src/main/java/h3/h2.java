package h3;

public class h2 {

    public String nearestPalindromic(String n) {
        if (n.length() == 1) {
            return String.valueOf(Integer.valueOf(n)-1);
        }
        char[] cs = n.toCharArray();
        for (int i = 0; i < cs.length / 2; i++) {
            if (cs[i] != cs[cs.length - i]) {
                cs[cs.length - i] = cs[i];
            }
        }
        return new String(cs);

    }
}
