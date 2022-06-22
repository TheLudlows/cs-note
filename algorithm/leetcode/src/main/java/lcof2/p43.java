package lcof2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class p43 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    static class CBTInserter {
        List<TreeNode> nodes = new ArrayList<>();

        public CBTInserter(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    nodes.add(node);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            System.out.println(nodes);
        }

        public int insert(int v) {
            int idx = nodes.size();
            TreeNode node = new TreeNode(v);
            nodes.add(node);
            TreeNode parent = nodes.get((idx - 1) / 2);

            if (idx % 2 == 0) {
                parent.right = node;
            } else {
                parent.left = node;
            }
            return parent.val;
        }

        public TreeNode get_root() {
            return nodes.get(0);
        }
    }

    /**
     * Your CBTInserter object will be instantiated and called as such:
     * CBTInserter obj = new CBTInserter(root);
     * int param_1 = obj.insert(v);
     * TreeNode param_2 = obj.get_root();
     */

    public static void main(String[] args) {
        CBTInserter in = new CBTInserter(new TreeNode(1));
        in.insert(2);

    }
}
