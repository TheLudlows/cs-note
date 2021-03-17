package lcof;

import java.util.*;

public class p07_buildTree {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(map, Arrays.stream(preorder).iterator(), 0, inorder.length - 1);
    }

    ///迭代器省了定位右子树的前序位置，root + mid - left +  1

    private static TreeNode build(Map<Integer, Integer> map, Iterator<Integer> it, int l, int r) {
        if (l > r) {
            return null;
        }
        int val = it.next();
        int mid = map.get(val);

        TreeNode node = new TreeNode(val);

        node.left = build(map, it, l, mid - 1);
        node.right = build(map,it, mid + 1, r);
        return node;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        TreeNode node = buildTree(arr,arr);
        System.out.println(node);
    }
}
