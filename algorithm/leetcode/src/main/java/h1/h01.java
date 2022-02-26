package h1;

public class h01 {
    public int dominantIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            for (; i < nums.length; j++) {
                if(j == i) {
                    continue;
                }
                if( nums[i] == 0) {
                    continue;
                }
                if(nums[j] / nums[i] < 2) {
                    break;
                }
            }
            if(j == nums.length) {
                return i;
            }
        }
        return -1;
    }
}
