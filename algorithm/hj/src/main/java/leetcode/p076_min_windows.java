package leetcode;

import java.util.HashMap;
import java.util.Map;

public class p076_min_windows {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        for(int i =0;i<t.length();i++) {
            char c = t.charAt(i);
            int n = map.getOrDefault(c, 0);
            map.put(c, n+1);
        }
        Map<Character, Integer> curMap = new HashMap();

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int left= 0,right  = 0;
        while(right<s.length()) {
            char c = s.charAt(right);
            if(!map.containsKey(c)) {
                right++;
                continue;
            }
            int n = curMap.getOrDefault(c, 0);
            curMap.put(c, n+1);
            while(eq(map,curMap)) {
                char remove = s.charAt(left);
                if(minLen > (right - left + 1)) {
                    minLen = right - left + 1;
                    start = left;
                }
                if(curMap.containsKey(remove)) {
                    int count = curMap.get(remove);
                    curMap.put(remove, count-1);
                }

                left++;
            }
            right++;
        }
        if(minLen == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(start, start+ minLen);
        }
    }

    private boolean eq(Map<Character, Integer> map, Map<Character, Integer> curMap) {
        for(Character c : map.keySet()) {
            if(curMap.get(c) == null) {
                return false;
            }
            if(curMap.get(c) < map.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = new p076_min_windows().minWindow("abcd", "bd");
        System.out.println(s);
    }
}

/**
 * use std::collections::HashMap;
 *
 * impl Solution {
 *     pub fn min_window(s: String, t: String) -> String {
 *  let s = s.as_bytes();
 *         let t = t.as_bytes();
 *         let mut cnt = HashMap::new();
 *         let mut map = HashMap::new();
 *         for b in t {
 *             *cnt.entry(*b).or_insert(0) += 1;
 *         }
 *         let mut min_window = i32::MAX;
 *         let mut start = 0;
 *         let (mut left, mut right) = (0, 0);
 *         let mut matches: usize = 0;
 *         while right < s.len() {
 *             if cnt.contains_key(&s[right]) {
 *                 *map.entry(s[right]).or_insert(0) += 1;
 *                 if cnt.get(&s[right]).unwrap() >= map.get(&s[right]).unwrap() {
 *                     matches += 1;
 *                 }
 *             }
 *             while matches == t.len() && left <= right {
 *                 let windows = (right - left + 1) as i32;
 *                 if min_window > windows {
 *                     start = left;
 *                     min_window = windows
 *                 }
 *                 if let Some(n) = map.get_mut(&s[left]) {
 *                     *n -= 1;
 *                     if *n < *cnt.get(&s[left]).unwrap() {
 *                         matches -= 1;
 *                     }
 *                 }
 *                 left += 1;
 *             }
 *             right += 1;
 *         }
 *         if start + min_window as usize > s.len() {
 *             return String::new();
 *         }
 *         String::from_utf8(s[start..start + min_window as usize].to_owned()).unwrap()
 *     }
 * }
 */
