package lcof2;

public class p49 {
    int res = 0;

    public int sumNumbers(TreeNode root) {

        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int cur) {
        if(root == null) {
            return;
        }
        int v = root.val;
        cur = cur * 10 + v;
        if (root.left == null && root.right == null) {
            res += cur;
            return;
        }

        dfs(root.left, cur );
        dfs(root.right, cur);
    }
}
