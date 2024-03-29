package lcof2;

public class p50 {

    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        sum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    private void sum(TreeNode root, int targetSum) {
        if(root == null) {
            return ;
        }
        if(root.val == targetSum) {
            res +=1;
        }

        sum(root.left, targetSum - root.val);
        sum(root.right, targetSum - root.val);
    }
}
