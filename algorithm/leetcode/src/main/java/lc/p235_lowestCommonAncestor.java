package lc;

// 寻找处于pq中间的节点
public class p235_lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return find(root,p,q);
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root.val > p.val && root.val > q.val) {
           return find(root.left,p,q);
        }
        if (root.val < p.val && root.val < q.val) {
            return find(root.right,p,q);
        }
        return root;
    }

}
