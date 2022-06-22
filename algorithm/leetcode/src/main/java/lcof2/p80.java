package lcof2;

import java.util.ArrayList;
import java.util.List;

public class p80 {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(n,k,1,cur,res);
        return res;
    }

    private void dfs(int n, int k, int start, List<Integer> cur, List<List<Integer>> res) {
        if(cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start;i<=n;i++ ) {
            cur.add(i);
            dfs(n,k,i+1,cur, res);
            cur.remove(cur.size()-1);
        }
    }

}
