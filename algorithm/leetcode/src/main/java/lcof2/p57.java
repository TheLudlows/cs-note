package lcof2;

import java.util.TreeSet;

public class p57 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        // 维护长度为k的窗口

        for (int i = 0; i < nums.length; i++) {

            Integer ceil = treeSet.ceiling(nums[i]);
            Integer floor = treeSet.floor(nums[i]);
            if (ceil != null && Long.valueOf(ceil) - Long.valueOf(nums[i]) <= t) {
                return true;
            }

            if (floor != null && Long.valueOf(nums[i]) - Long.valueOf(floor) <= t) {
                return true;
            }
            treeSet.add(nums[i]);

            if (i >= k) {
                treeSet.remove(nums[i - k]);
            }

        }
        return false;
    }
}
