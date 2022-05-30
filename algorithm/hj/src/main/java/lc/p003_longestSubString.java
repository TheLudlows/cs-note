package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口+map， 移动式删除过去窗口的所有元素
 */
public class p003_longestSubString {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.get(c) == null) {
                map.put(c, r);
            } else {
                int oldIdx = map.get(c);
                for (int i = l; i <= oldIdx; i++) {
                    map.remove(s.charAt(i));
                }
                l = oldIdx + 1;

                map.put(c, r);
            }
            r++;
            max = Math.max(r - l, max);
        }
        return max;
    }

    public static void main(String[] args) {
        new p003_longestSubString().lengthOfLongestSubstring("abba");
    }

}

