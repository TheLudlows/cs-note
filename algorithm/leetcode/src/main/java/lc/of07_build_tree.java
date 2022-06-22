package lc;

import java.util.HashMap;
import java.util.Map;

public class of07_build_tree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return  build(map, preorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(Map<Integer, Integer> map, int[] preorder, int left, int right, int inLeft, int inRight) {
        if(left > right) {
            return null;
        }
        int v = preorder[left];
        TreeNode node = new TreeNode(v);
        int idx = map.get(v);
        int leftLen = idx - inLeft;
        int rightLen = inRight - idx;
        node.left = build(map, preorder, left+1, left+leftLen, inLeft,idx-1);
        node.right = build(map, preorder, left+leftLen+1, right, idx+1, inRight);
        return  node;
    }

}
