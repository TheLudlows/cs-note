package lcof2;

import java.util.HashMap;
import java.util.Map;

public class p10 {
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(sum, 1);
        System.out.println(map);
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                int count = map.get(sum - k);
                result+=count;
            }
            int count = map.getOrDefault(sum, 0);
            map.put(sum, ++ count);
        }
        return result;

    }

    public static void main(String[] args) {
        subarraySum(new int[]{1,-1,0}, 0);
    }
}
