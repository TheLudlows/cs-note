package lc;

public class p055_jump {

    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            if(i > max) {
                return false;
            }
            max = Math.max(max, i+ nums[i]);
            if(max >= nums.length) {
                return true;
            }
        }
        return false;
    }
}
