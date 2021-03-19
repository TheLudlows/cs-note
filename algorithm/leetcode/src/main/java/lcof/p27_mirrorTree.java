package lcof;

public class p27_mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        exchange(root);
        return root;
    }

    private void exchange(TreeNode root) {
        if(root != null) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            exchange(root.left);
            exchange(root.right);
        }
    }
}
