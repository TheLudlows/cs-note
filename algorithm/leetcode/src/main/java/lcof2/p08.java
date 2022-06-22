package lcof2;

import java.util.Arrays;

import static com.sun.prism.impl.PrismSettings.trace;

public class p08 {
    public int minSubArrayLen(int target, int[] nums) {
        int[] sum = new int[nums.length + 1];

        for (int i = 0; i < sum.length; i++) {
            sum[i] += nums[i - 1];
        }

        int minLen = Integer.MAX_VALUE;
        System.out.println(Arrays.toString(sum));
        for (int i = 0; i < sum.length; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[j] - sum[i] >= target) {
                    minLen = Math.min(j - i, minLen);
                }
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }
    }

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
