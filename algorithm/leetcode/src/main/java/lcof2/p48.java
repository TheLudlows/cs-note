package lcof2;

import java.util.Arrays;
import java.util.Iterator;

public class p48 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) {
                return "#";
            }
            return root.val +"," + serialize(root.left) + "," + serialize(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] datas = data.split(",");
            Iterator<String> it = Arrays.asList(datas).iterator();
            return buildTree(it);
        }

        private TreeNode buildTree(Iterator<String> it) {
            String v = it.next();
            if(v.equals("#")) {
                return null;
            }
            Integer intV = Integer.parseInt(v);
            TreeNode node = new TreeNode(intV);
            node.left = buildTree(it);
            node.right = buildTree(it);
            return node;
        }
    }



}
