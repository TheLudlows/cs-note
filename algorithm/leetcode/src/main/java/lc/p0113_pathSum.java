package lc;

import java.util.ArrayList;
import java.util.List;

public class p0113_pathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        sum(root, targetSum, cur, ret);
        return ret;
    }

    public void sum(TreeNode node, int target, List<Integer> cur, List<List<Integer>> ret) {
        if (node == null) {
            return;
        }
        cur.add(node.val);
        if (target == node.val && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(cur));
        }
        sum(node.left, target - node.val, cur, ret);
        sum(node.right, target - node.val, cur, ret);
        cur.remove(cur.size() - 1);
    }
}
