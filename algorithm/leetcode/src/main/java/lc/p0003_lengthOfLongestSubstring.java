package lc;

import java.util.HashMap;
import java.util.Map;

public class p0003_lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        int max = 0;
        while (j < chars.length) {
            if (map.containsKey(chars[j])) {
                int end = map.remove(chars[j]);
                for (int k = i; k <= end; k++) {
                    map.remove(chars[k]);
                }
                i = end + 1;
            }
            map.put(chars[j], j);
            max = Math.max(j - i + 1, max);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }
}
