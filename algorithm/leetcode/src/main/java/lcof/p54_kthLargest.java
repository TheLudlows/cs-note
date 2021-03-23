package lcof;

import java.util.ArrayList;
import java.util.List;

// 中序遍历 有序
public class p54_kthLargest {
    List<TreeNode> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        trace(root);
        return list.get(list.size() - k).val;
    }

    private void trace(TreeNode root) {
        if(root == null) {
            return;
        }
        trace(root.left);
        list.add(root);
        trace(root.right);
    }
}
