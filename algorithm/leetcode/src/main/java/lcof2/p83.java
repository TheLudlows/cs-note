package lcof2;

import java.util.ArrayList;
import java.util.List;

public class p83 {
    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        vis = new boolean[nums.length];
        dfs(nums, cur, res);
        return  res;
    }

    private void dfs(int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if(cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(!vis[i]) {
                vis[i] = true;
                cur.add(nums[i]);
                dfs(nums, cur,res);
                cur.remove(cur.size()-1);
                vis[i] = false;
            }
        }
    }
}
