package lcof2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p07 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < nums.length - 2; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int sum = 0 - nums[i];
            while (j < k) {
                int subSum = nums[j] + nums[k];
                if (sum > subSum) {
                    j++;
                } else if (sum < subSum) {
                    k--;
                } else {
                    if(j> i + 1 && nums[j] == nums[j-1] && k < nums.length-1 && nums[k] == nums[k+1]) {
                        continue;
                    }
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
}
