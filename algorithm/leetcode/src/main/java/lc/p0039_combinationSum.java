package lc;

import java.util.*;


/// start 0 剪纸放重
public class p0039_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates, ret, target, cur, 0);
        return ret;
    }

    private void combine(int[] candidates, List<List<Integer>> ret, int target, List<Integer> cur, int start) {

        if (target < 0) {
            return;
        } else if (target == 0) {
            ret.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            cur.add(candidates[i]);
            combine(candidates, ret, target - candidates[i], cur, i);
            cur.remove(cur.size() - 1);
        }
    }
}