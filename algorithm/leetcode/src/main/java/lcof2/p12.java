package lcof2;

public class p12 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(Integer item : nums) {
            sum += item;
        }
        int cur = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++) {
            if( cur * 2 + nums[i] == sum) {
                    result ++;
            }
            cur += nums[i];
        }
        return result;

    }
}
