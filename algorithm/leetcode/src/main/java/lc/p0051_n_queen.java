package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class p0051_n_queen {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        boolean[] col = new boolean[n];
        Arrays.fill(col, false);
        HashSet<Integer> right = new HashSet<Integer>();
        HashSet<Integer> left = new HashSet<Integer>();
        List<Integer> cur = new ArrayList<>();

        dfs(0, n, col, right, left, cur);
        return res;
    }

    // 第i行开始
    private void dfs(int i, int n, boolean[] col, HashSet<Integer> right, HashSet<Integer> left, List<Integer> cur) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            // add res
            for (Integer k : cur) {
                char[] cs = new char[n];
                Arrays.fill(cs, '.');
                cs[k] = 'Q';
                list.add(new String(cs));
            }
            res.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!col[j] && !right.contains(i - j) && !left.contains(i + j)) {
                col[j] = true;
                right.add(i - j);
                left.add(i + j);
                cur.add(j);
                dfs(i + 1, n, col, right, left, cur);
                col[j] = false;
                right.remove(i - j);
                left.remove(i + j);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
