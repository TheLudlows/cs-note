package lcof2;

import java.util.ArrayList;
import java.util.List;

public class p79 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, 0, cur, res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));

        for(int i=start;i<nums.length;i++) {
            cur.add(nums[i]);
            dfs(nums, i+1, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
