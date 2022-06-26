package lcof2;

import java.util.Arrays;

import static com.sun.prism.impl.PrismSettings.trace;

public class p08 {

    public static int minSubArrayLen1(int target, int[] nums) {

        int i= 0,j= 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(j < nums.length) {
            sum +=nums[j];
            while(sum > target && i <= j) {
                if(sum >= target) {
                    min = Math.min(min, j - i + 1);
                }
                sum -= nums[i];
                i++;
            }
            j++;
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[] {2,3,1,2,4,3};
        minSubArrayLen1(7, arr);
    }
}
