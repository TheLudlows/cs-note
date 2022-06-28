package lcof2;

import java.util.Arrays;

public class p101 {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (Integer i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;
        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (boolean[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    /**
     * 0 1 2 3 4 5
     * 2 T F T F F F
     * 3 T F T T F T
     * 1 T T
     */



    public boolean canPartition2(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        mem = new int[nums.length+1][sum+1];
        return find(nums, nums.length - 1, sum);
    }
    int[][] mem;

    private boolean find(int[] nums, int i, int sum) {

        if (sum == 0) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        if(mem[i][sum] != 0) {
            return mem[i][sum] == 1;
        }

        boolean ret = find(nums, i - 1, sum) || find(nums, i - 1, sum - nums[i]);

        mem[i][sum] = ret?1:-1;
        return ret;
    }
}
