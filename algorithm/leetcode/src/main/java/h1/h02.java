package h1;

import java.util.Arrays;

public class h02 {
    public void wiggleSort(int[] nums) {
        int[] arr = Arrays.copyOf(nums,nums.length);
        Arrays.sort(arr);
        int i = 0;
        int j = nums.length-1;

        for(int k = 0;k<nums.length;k++) {
            if(k % 2 == 0) {
                nums[k] = arr[i++];
            } else {
                nums[k] = arr[j--];
            }
        }
    }
}
