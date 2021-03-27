package lcof;

import java.util.ArrayList;
import java.util.List;

public class p34_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        path(root, target, cur, ret);
        return ret;
    }

    private void path(TreeNode root, int target, List<Integer> cur, List<List<Integer>> ret) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        if (target == root.val && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(cur));
        }
        path(root.left, target - root.val, cur, ret);
        path(root.right, target - root.val, cur, ret);
        cur.remove(cur.size() - 1);
    }
}
