package lcof;

import java.util.Arrays;

public class p03_findRepeatNumber {
    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                System.out.println(Arrays.toString(nums));
                utils.swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
