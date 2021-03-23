package lcof;

import java.util.HashMap;
import java.util.Map;


///双指针 map
public class p48_lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int size = 0;
        int max = 0;
        for (int i = 0, start = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                size++;
            } else {
                start = Math.max(map.get(chars[i]), start);
                size = i - start;
            }
            map.put(chars[i], i);
            max = Math.max(max, size);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
