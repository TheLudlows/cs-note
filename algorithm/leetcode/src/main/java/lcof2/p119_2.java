package lcof2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class p119_2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i : set) {
            // 减支
            if (!set.contains(i - 1)) {
                int n = i;
                int count = 1;
                while (set.contains(n + 1)) {
                    n+=1;
                    count+=1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    /**
     * Set<Integer> num_set = new HashSet<Integer>();
     *         for (int num : nums) {
     *             num_set.add(num);
     *         }
     *
     *         int longestStreak = 0;
     *
     *         for (int num : num_set) {
     *             if (!num_set.contains(num - 1)) {
     *                 int currentNum = num;
     *                 int currentStreak = 1;
     *
     *                 while (num_set.contains(currentNum + 1)) {
     *                     currentNum += 1;
     *                     currentStreak += 1;
     *                 }
     *
     *                 longestStreak = Math.max(longestStreak, currentStreak);
     *             }
     *         }
     *
     *         return longestStreak;
     */
    /**
     * use std::cmp::max;
     * use std::collections::HashSet;
     * <p>
     * impl Solution {
     * pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
     * let mut set = HashSet::new();
     * nums.iter().for_each(|e| { set.insert(e); });
     * let mut longest = 0;
     * for i in set.iter() {
     * if !set.contains(&(*i - 1)) {
     * let mut cur = *i + 1;
     * let mut count = 1;
     * while set.contains(&cur) {
     * count += 1;
     * cur+=1;
     * }
     * longest = max(longest, count)
     * }
     * }
     * longest
     * }
     * }
     * #[test]
     * fn test() {
     * <p>
     * }
     *
     * @param nums
     * @return
     */

    public int longestIncSubSeq(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}
