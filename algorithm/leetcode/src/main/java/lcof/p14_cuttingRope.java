package lcof;

import java.util.Arrays;

// 可剪可不剪
public class p14_cuttingRope {
    public int cuttingRope(int n) {
        long[] dp = new long[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] =Math.max(dp[i], Math.max( j * (i-j) , dp[i - j] * j))%1000000007;
            }
        }
        //System.out.println(Arrays.toString(dp));
        return (int)dp[n];
    }
}
