package h3;

import lc.TreeNode;

public class h3 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p!= null && q == null) {
            return false;
        }

        if(q!= null && p == null) {
            return false;
        }

       return  p.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
