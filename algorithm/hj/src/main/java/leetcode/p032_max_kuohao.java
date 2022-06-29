package leetcode;

public class p032_max_kuohao {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length() + 1];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i == 1) {
                        dp[i] = 2;
                    } else {
                        dp[i] = dp[i - 2] + 2;
                    }
                } else {
                    if (i > dp[i - 1] && s.charAt(i - dp[i - 1] - 1) == '(') {
                        if (i > dp[i - 1] + 1) {
                            dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }

                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
