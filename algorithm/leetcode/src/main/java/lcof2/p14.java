package lcof2;

import java.util.HashMap;
import java.util.Map;

public class p14 {
    public boolean checkInclusion(String s1, String s2) {

        int r = 0,l = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(char c: s1.toCharArray()) {
           int n = map.getOrDefault(c, 0);
           map.put(c, n+1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();

        for(int i=0;i<s1.length();i++) {
           int n = windowMap.getOrDefault(s2.charAt(i), 0);
            windowMap.put(s2.charAt(i), n+1);
            r++;
        }
        if(map.equals(windowMap)) {
            return true;
        }

        while(r < s2.length()) {
            char c = s2.charAt(r);
            int n =  windowMap.getOrDefault(c, 0);
            windowMap.put(c, n+1);
            char leftChar = s2.charAt(l);
            int leftN = windowMap.get(leftChar);
            if(leftN == 1) {
                windowMap.remove(leftChar);
            } else {
                windowMap.put(leftChar, leftN - 1);
            }
            if(windowMap.equals(map)) {
                return  true;
            }
            r++;
            l++;
        }
        return false;

    }

    public static void main(String[] args) {
        new p14().checkInclusion("ab","1abc");
    }
}
