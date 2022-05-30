package lc;

import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap();
        int max = 0;
        for(int i=0;i<wall.size();i++) {
            int prefix = 0;
            for(int j =0;j<wall.get(i).size()-1;j++) {
                prefix+=wall.get(i).get(j);
                int n = 1;
                if(map.containsKey(prefix)) {
                    n = map.get(prefix);
                    n++;
                }
                map.put(prefix, n);
                max = Math.max(max, n);
            }
        }

        return wall.size() - max;
    }
}
