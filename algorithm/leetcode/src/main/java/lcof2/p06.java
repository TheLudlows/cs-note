package lcof2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p06 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for(int i=0;i<numbers.length;i++) {
                if(map.containsKey(target - numbers[i])) {
                    int idx = map.get(target - numbers[i]);
                    int[] arr = new int[] {i, idx};
                     Arrays.sort(arr);
                    return arr;
                }
                map.put(numbers[i], i);
            }
            return new int[0];
        }
    }
}
