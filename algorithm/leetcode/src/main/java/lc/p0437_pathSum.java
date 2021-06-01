package lc;

public class p0437_pathSum {

    public int pathSum(TreeNode root, int targetSum) {
        if (root != null) {
            return findPath(root, targetSum) + pathSum(root.left, targetSum)
                    + pathSum(root.right, targetSum);
        }
        return 0;
    }

    private int findPath(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (root.val == targetSum) {
            ret += 1;
        }
        ret += findPath(root.left, targetSum - root.val)
                + findPath(root.right, targetSum - root.val);
        return ret;
    }
}
