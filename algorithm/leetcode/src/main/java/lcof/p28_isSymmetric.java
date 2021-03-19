package lcof;

public class p28_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
       return root != null && same(root.left, root.right);
    }

    private boolean same(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left != null && right!= null) {
            return left.val == right.val
                    && same(left.left,right.right)
                    && same(left.right, right.left);
        } else {
            return false;
        }
    }
}
