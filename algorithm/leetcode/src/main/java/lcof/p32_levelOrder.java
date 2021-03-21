package lcof;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class p32_levelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                list.add(node.val);
            }
        }

        int[] ret = new int[list.size()];

        for(int i=0;i<ret.length;i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
