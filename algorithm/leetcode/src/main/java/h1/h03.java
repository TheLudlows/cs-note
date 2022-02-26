package h1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class h03 {

    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur);
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> cur) {
        if (cur.size() > 1) {
            if(!set.contains(cur)) {
                List<Integer> newList = new ArrayList<>(cur);
                res.add(newList);
                set.add(newList);
            }
        }
        for (int i = idx; i < nums.length; i++) {
            if (cur.isEmpty() || cur.get(cur.size() - 1) <= nums[i]) {
                cur.add(nums[i]);
                dfs(nums, i+1, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}
