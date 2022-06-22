package lcof2;

public class p92 {

    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[s.length()][2];
        if(s.charAt(0) == '1') {
            dp[0][0] = 1;
        } else {
            dp[0][1] = 1;
        }
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i) == '1') {
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]);
                dp[i][0] = dp[i-1][0] + 1;
            } else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + 1;
            }
        }
        int idx = s.length()-1;
        return Math.min(dp[idx][0], dp[idx][1]);
    }

    public static void main(String[] args) {
        new p92().minFlipsMonoIncr("010");
    }
}
/**
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是 单调递增 的。
 *
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 s，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 *
 * 返回使 s 单调递增 的最小翻转次数。
 *
 * 0010001
 */