package lcof2;

import java.util.Arrays;

public class p90 {
    public int subRob(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        if(nums.length == 1) {
            return nums[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return  nums[0];
        }
        return  Math.max(subRob(Arrays.copyOfRange(nums, 0, nums.length-1)), subRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

}
