package lc;


/// 都不为空 返回root，否则返回非空的
public class p236_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        if (right == null) {
            return left;
        } else if (left == null) {
            return right;
        } else {
            return root;
        }
    }

}
