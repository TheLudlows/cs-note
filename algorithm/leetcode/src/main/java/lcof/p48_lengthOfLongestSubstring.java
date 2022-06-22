package lcof;

import java.util.HashMap;
import java.util.Map;


///双指针 map
public class p48_lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(right < s.length()) {
            char c = s.charAt(right);
            if(map.containsKey(c)) {
                int oldIdx = map.get(c);
                for(int i = left;i<=oldIdx;i++) {
                    map.remove(s.charAt(i));
                }
                left = oldIdx + 1;
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
