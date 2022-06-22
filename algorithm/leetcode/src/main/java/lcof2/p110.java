package lcof2;

import java.util.ArrayList;
import java.util.List;

public class p110 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        func(graph,0, cur, result);
        return result;
    }

    private void func(int[][] graph, int i, List<Integer> cur, List<List<Integer>> result) {
        if(i == graph.length-1) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int x : graph[i]) {
            cur.add(x);
            func(graph, x, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
