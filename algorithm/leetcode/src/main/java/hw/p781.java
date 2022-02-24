package hw;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for (int i : answers) {
            if(i == 0) {
               total++;
               continue;
            }
            if (map.containsKey(i+1)) {
                int v = map.get(i+1);
                v --;
                map.put(i+1, v);
                if(v == 0) {
                    map.remove(i+1);
                }
            } else {
                map.put(i+1, i);
                total+= i+1;
            }
        }
        return total;
    }
}
