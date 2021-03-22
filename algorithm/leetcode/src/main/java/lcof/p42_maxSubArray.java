package lcof;

public class p42_maxSubArray {

    public int maxSubArray(int[] nums) {
        int max = 0;
        int cur = 0;

        for (int n : nums) {
            cur  = Math.max(cur+n,n);
            max = Math.max(max, cur);
        }
        return max;
    }
}
