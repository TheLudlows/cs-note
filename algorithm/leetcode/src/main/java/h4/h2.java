package h4;


import lc.TreeNode;

public class h2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode node = null;
        if (root1 == null && root2 != null) {
            node = new TreeNode(root2.val);
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);

        }

        if (root1 != null && root2 == null) {
            node = new TreeNode(root1.val);
            node.left = mergeTrees(null, root1.left);
            node.right = mergeTrees(null, root1.right);
        }
        if (root1 != null && root2 != null) {
            node = new TreeNode(root1.val + root2.val);
            node.left = mergeTrees(root2.left, root1.left);
            node.right = mergeTrees(root2.right, root1.right);
        }

        return node;
    }
}
