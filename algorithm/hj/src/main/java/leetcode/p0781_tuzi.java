package leetcode;

import java.util.HashMap;
import java.util.Map;

public class p0781_tuzi {
    // 注意说0 和 map放回去
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap();
        int total = 0;
        for(Integer i : answers) {
            if(i == 0) {
                total++;
                continue;
            }
            if(map.containsKey(i)) {
                int n = map.get(i);
                n--;
                if(n == 0) {
                    map.remove(i);
                } else {
                    map.put(i, n);
                }
            } else {
                map.put(i, i);
                total+=i+1;
            }
        }
        return total;
    }
}
