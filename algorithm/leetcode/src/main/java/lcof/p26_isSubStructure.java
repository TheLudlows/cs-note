package lcof;

// 双递归 注意先找起始点
public class p26_isSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        return (A.val == B.val && sub(A.right, B.right) && sub(A.left, B.left))
                || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean sub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && sub(A.left, B.left) && sub(A.right, B.right);
    }

}
