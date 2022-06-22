package lcof2;

import java.util.HashMap;
import java.util.Map;

public class p11 {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0,-1);
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) {
                sum+=-1;
            } else {
                sum +=1;
            }

            if(map.containsKey(sum)) {
                max = Math.max(i - map.get(sum), max);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
