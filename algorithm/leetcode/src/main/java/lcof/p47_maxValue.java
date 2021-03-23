package lcof;

import java.util.Arrays;

public class p47_maxValue {

    public int maxValue(int[][] grid) {
        //int[][] dp = new int[grid.length][grid[0].length];
        int[][] dp = grid.clone();
        for(int i=1;i<dp[0].length;i++) {
            dp[0][i] += dp[0][i-1];
        }
        for(int i=1;i<dp.length;i++) {
            dp[i][0] += dp[i-1][0];
        }
        print2dArray(dp);
        for(int i = 1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                dp[i][j] += Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        print2dArray(dp);
        return dp[dp.length-1][dp[0].length-1];
    }

    private void print2dArray(int[][] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

}
