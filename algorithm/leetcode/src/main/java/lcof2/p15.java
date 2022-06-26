package lcof2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p15 {
        public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length()) {
            return  list;
        }
        int r = 0,l = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(char c: p.toCharArray()) {
           int n = map.getOrDefault(c, 0);
           map.put(c, n+1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();

        for(int i=0;i<p.length();i++) {
           int n = windowMap.getOrDefault(s.charAt(i), 0);
            windowMap.put(s.charAt(i), n+1);
            r++;
        }
        if(map.equals(windowMap)) {
            list.add(l);
        }

        while(r < s.length()) {
            char c = s.charAt(r);
            int n =  windowMap.getOrDefault(c, 0);
            windowMap.put(c, n+1);
            char leftChar = s.charAt(l);
            int leftN = windowMap.get(leftChar);
            if(leftN == 1) {
                windowMap.remove(leftChar);
            } else {
                windowMap.put(leftChar, leftN - 1);
            }
            r++;
            l++;
            if(windowMap.equals(map)) {
                list.add(l);
            }
        }
        return list;

    }

}
