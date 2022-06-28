package lcof2;

import java.util.Arrays;

public class p103 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }
        for (int i = 1; i < dp[0].length; i++) {
            if (i >= coins[0] && dp[0][i - coins[0]] != Integer.MAX_VALUE) {
                dp[0][i] = Math.min(dp[0][i - coins[0]] + 1, dp[0][i]);
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= coins[i]) {
                    if (dp[i][j - coins[i]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j - coins[i]] + 1, dp[i][j]);
                    }
                    if (dp[i - 1][j - coins[i]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i - 1][j - coins[i]] + 1, dp[i][j]);
                    }
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
            }
        }

        int ret = dp[dp.length - 1][dp[0].length - 1];
        if (ret == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ret;
        }

    }

    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i >= c) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    /**
     * 0 1  2  3  4  5
     * 1 0 1 -1 -1 -1 -1
     * 2 0 1  1  2
     * 4 0
     */

    int[] mem;

    public int coinChange2(int[] coins, int amount) {
        mem = new int[amount + 1];
        return func(coins, amount);
    }

    private int func(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (mem[amount] != 0) {
            return mem[amount];
        }
        int min = Integer.MAX_VALUE;

        for (int c : coins) {
            int count = func(coins, amount - c);
            if (count == -1) {
                continue;
            }
            min = Math.min(min, count + 1);
        }
        min = min == Integer.MAX_VALUE ? -1 : min;
        mem[amount] = min;
        return min;
    }
}
