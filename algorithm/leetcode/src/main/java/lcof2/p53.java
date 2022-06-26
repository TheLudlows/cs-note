package lcof2;

import java.util.Stack;

public class p53 {

    TreeNode pre;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null) {
                return root;
            }
            if (root == p) {
                pre = p;
            }
            // access
            root = root.right;
        }
        return null;
    }
}
