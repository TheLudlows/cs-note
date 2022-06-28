package lcof2;

public class p104 {
    public int combinationSum4(int[] nums, int target) {
        int ret = func(nums, target);
        return ret;
    }

    public int combinationSum42(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }

    private int func(int[] nums, int target) {
        if (target < 0) {
            return 0;
        }

        if (target == 0) {
            return 1;
        }
        int ret = 0;
        for (int n : nums) {
            int count = func(nums, target - n);
            ret += count;

        }
        return ret;
    }
}
