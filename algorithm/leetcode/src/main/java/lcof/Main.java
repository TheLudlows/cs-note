package lcof;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String[] arr = line1.split(",");
        List<String> list = Arrays.asList(arr);
        int n = Integer.parseInt(line2);
        Node root = build(list);

        List<List<Integer>> sums = pathSum(root, n);
        sums.stream().sorted(Comparator.comparingInt(List::size));
        System.out.println(sums.get(sums.size()-1));
    }

    static Node build(List<String> list) {
        Node root = new Node(Integer.valueOf(list.get(0)));
        root.left = buildTree(list, 1);
        root.right = buildTree(list, 2);
        return root;
    }

    private static Node buildTree(List<String> chars, int i) {

        if (i >= chars.size() || chars.get(i).equals("null")) {
            return null;
        }
        Node root = new Node(Integer.valueOf(chars.get(i)));
        root.left = buildTree(chars,i*2+1);
        root.right = buildTree(chars, i*2+2);

        return root;
    }

    public static List<List<Integer>> pathSum(Node root, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        path(root, target, cur, ret);
        return ret;
    }

    private static void path(Node root, int target, List<Integer> cur, List<List<Integer>> ret) {
        if (root == null || target < 0) {
            return;
        }
        cur.add(root.val);
        if (target == root.val) {
            ret.add(new ArrayList<>(cur));
        }
        path(root.left, target - root.val, cur, ret);
        path(root.right, target - root.val, cur, ret);
        cur.remove(cur.size() - 1);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        Node(int x) {
            val = x;
        }
    }
}

