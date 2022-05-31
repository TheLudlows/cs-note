package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 一般的中序遍历序列化 不能区分镜像子树，镜像子树不能算相同的
public class p652_chongfuzishu {
    Map<String,Integer> map = new HashMap();
    List<TreeNode> list = new ArrayList<TreeNode>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return list;
    }

    private String dfs(TreeNode root) {
        if(root == null) {
            return "#";
        }
        String path = dfs(root.left) + "," +  root.val+"," + dfs(root.right);
        int n = map.getOrDefault(path, 0);
        n++;
        if(n == 2) {
            list.add(root);
        }
        map.put(path, n);

        System.out.println(path);
        return path;
    }
}
