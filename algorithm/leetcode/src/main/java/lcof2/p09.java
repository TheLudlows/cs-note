package lcof2;

public class p09 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int multiply = 1;
        int result = 0;

        while (j < nums.length) {
            multiply *= nums[j];
            while (multiply >= k && i <= j) {
                multiply /= nums[i];
                i++;
            }
            result += j - i + 1;
            j++;
        }
        return result;
    }
}
