package leetcode;

public class p053_max {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i=1;i<nums.length;i++) {
            max = Math.max(Math.max(max, nums[i]),nums[i]+ max) ;
        }
        return max;
    }
}
