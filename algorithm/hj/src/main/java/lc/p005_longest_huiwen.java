package lc;

public class p005_longest_huiwen {
    public String longestPalindrome(String s) {
        int max = 0;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = findMax(i, i, s);
            String s2 = findMax(i, i + 1, s);
            if(s1.length() > max) {
                str = s1;
            }
            if(s2.length() > max) {
                str = s2;
            }
        }
        return str;
    }

    public String findMax(int i, int j, String s) {

        while(i>=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        // sub 不包含j下标元素
        return s.substring(i+1,j);
    }

    public static void main(String[] args) {
        System.out.println("aac".substring(0,1));
    }
}
