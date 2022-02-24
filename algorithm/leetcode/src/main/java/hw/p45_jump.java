package hw;

public class p45_jump {
    public int jump(int[] nums) {
        int max = 0;
        int step = 0;
        int end = 0;

        for(int i=0;i<nums.length;i++) {
            max = Math.max(max,i+nums[i]);
            if(i == end) {
                step ++;
                end = max;
            }
        }
        return step;
    }
}
