package lcof2;

import java.util.Arrays;
import java.util.List;

public class p100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = list.get(j) + dp[i - 1][j];
                } else if(j == i) {
                    dp[i][j] = list.get(j) + dp[i - 1][j-1];
                } else {
                    dp[i][j] = list.get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        for(int i=0;i<dp.length;i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < dp[0].length; i++) {
            min = Math.min(dp[dp.length - 1][i], min);
        }
        return min;
    }
}
