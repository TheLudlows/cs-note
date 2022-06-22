package lcof2;

public class p47 {
    public TreeNode pruneTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.right == null && root.left == null) {
            return null;
        } else {
            return root;
        }
    }


}
