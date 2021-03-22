package lc;

import java.util.ArrayList;
import java.util.List;

public class p0216_combinationSum3 {
    int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        this.k = k;
        combine(ret, n, cur, 1);
        return ret;
    }

    private void combine(List<List<Integer>> ret, int target, List<Integer> cur, int start) {
        if (target < 0) {
            return;
        } else if (target == 0 && cur.size() == k) {
            ret.add(new ArrayList<>(cur));
            return;
        }
        if (cur.size() > k) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            cur.add(i);
            combine(ret, target - i, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
