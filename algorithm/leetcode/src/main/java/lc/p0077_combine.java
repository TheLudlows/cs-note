package lc;

import java.util.ArrayList;
import java.util.List;

public class p0077_combine {
    int k;
    int n;

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        this.k = k;
        this.n = n;
        combine(ret, cur, 1);
        return ret;
    }

    private void combine(List<List<Integer>> ret, List<Integer> cur, int start) {
        if (cur.size() == k) {
            ret.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            combine(ret, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }


}
