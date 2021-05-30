package iv;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        pl(arr);

    }

    public static List<List<Integer>> pl(int[] arr) {
        boolean[] vis = new boolean[arr.length];
        for (int i = 0; i < vis.length; i++) {
            vis[i] = false;
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(arr, vis, res, new ArrayList<>());
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        return res;
    }

    public static void dfs(int[] arr, boolean[] vis, List<List<Integer>> res, List<Integer> cur) {

        if (cur.size() == arr.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                cur.add(arr[i]);
                dfs(arr, vis, res, cur);
                vis[i] = false;
                cur.remove(cur.size() - 1);
            }
        }

    }
}
