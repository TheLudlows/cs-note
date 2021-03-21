package lcof;

import java.util.*;

public class p32_levelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                tmp.add(node.val);
            }
            if (level % 2 == 1) {
                Collections.reverse(tmp);
            }
            list.add(tmp);
            level++;
        }
        return list;
    }
}
