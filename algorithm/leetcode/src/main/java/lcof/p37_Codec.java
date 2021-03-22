package lcof;

import java.util.ArrayDeque;
import java.util.Queue;

// 先序遍历
public class p37_Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        recur(root, buffer);
        return buffer.toString();
    }

    private static void recur(TreeNode node, StringBuffer sb) {

        if (node == null) {
            sb.append('#').append(',');
            return;
        }
        sb.append(node.val).append(',');
        recur(node.left, sb);
        recur(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return buildTree(arr);
    }


    static Integer idx = 0;

    public static TreeNode buildTree(String[] arr) {
        if (arr[idx].equals("#")) {
            idx++;
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(arr[idx]));
        idx++;
        treeNode.left = buildTree(arr);
        treeNode.right = buildTree(arr);
        return treeNode;
    }


    public static void main(String[] args) {
        TreeNode t = deserialize("1,2,4,#,#,5,#,#,3,#,#");
        System.out.println(serialize(t));
    }

}
