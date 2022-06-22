package lcof2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p82 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(candidates, cur, res, target, 0);
        return res;
    }

    private void dfs(int[] candidates, List<Integer> cur, List<List<Integer>> res, int target, int start) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<>(cur));
        }

        // start 排列和组合的差异
        for(int i=start;i<candidates.length;i++) {
            if(i> start && candidates[i] == candidates[i-1]) {
                continue;
            }
            cur.add(candidates[i]);
            dfs(candidates, cur, res, target - candidates[i], i+1);
            cur.remove(cur.size()-1);
        }
    }

    public static void combinationSum2(String[] args) {
        new p84().permute(new int[]{1,1,2});
    }
}
