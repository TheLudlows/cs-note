package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p0040_combinationSum {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            combine(candidates, ret, target - candidates[i], cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
