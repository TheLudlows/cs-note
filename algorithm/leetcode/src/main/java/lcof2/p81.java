package lcof2;

import java.util.ArrayList;
import java.util.List;

public class p81 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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

        // start 排列和组合的差异, 每个元素能否复用 start start+1 , 重复使用
        for(int i=start;i<candidates.length;i++) {
            cur.add(candidates[i]);
            dfs(candidates, cur, res, target - candidates[i], i);
            cur.remove(cur.size()-1);
        }
    }
}
