package io.four;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.ceil;

public class Tree {


    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 创建tree
     *
     * @param arr
     * @param i
     * @return
     */
    static Node createTree(int arr[], int i) {
        if (i >= arr.length || arr[i] == -1)
            return null;
        Node root = new Node(arr[i]);
        root.left = createTree(arr, 2 * i + 1);
        root.right = createTree(arr, 2 * i + 2);
        return root;
    }

    public static void main(String[] args) {

        System.out.println(ceil(1.1));
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Node root = createTree(arr, 0);
        iterativePre(root);
    }

    /**
     * 递归先序遍历
     *
     * @param node
     */
    static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);

    }

    /**
     * 递归中序遍历
     *
     * @param node
     */
    static void midOrder(Node node) {
        if (node == null) {
            return;
        }
        midOrder(node.left);
        System.out.print(node.val + " ");
        midOrder(node.right);

    }

    /**
     * 递归后续遍历
     *
     * @param node
     */
    static void lastOrder(Node node) {
        if (node == null) {
            return;
        }
        lastOrder(node.left);
        lastOrder(node.right);
        System.out.print(node.val + " ");

    }

    /**
     * 非递归先序遍历
     *
     * @param root
     */
    static void iterativePre(Node root) {
        Stack<Node> s = new Stack();
        Node p = root;
        while (!s.empty() || p != null) {
            while (p != null) {
                s.push(p);
                System.out.print(p.val + " ");
                p = p.left;
            }
            p = s.pop();
            p = p.right;
        }
    }

    static void iterativePre2(Node root) {
        if (root == null)
            return;
        Node p = root;
        Stack<Node> stack = new Stack();
        stack.add(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            System.out.print(p.val + " ");
            if (p.right != null)// 先右再左即可
                stack.push(p.right);
            if (p.left != null)
                stack.push(p.left);
        }
    }

    static void iterativeMid(Node root) {
        Stack<Node> s = new Stack();
        Node p = root;
        while (!s.empty() || p != null) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            System.out.print(p.val + " ");
            p = p.right;
        }
    }

    /**
     * 非递归后续遍历，双栈
     * @param root
     */
    static void iterativePos(Node root) {
        Stack<Node> s = new Stack(), s2 = new Stack();
        Node p;
        s.push(root);
        while (!s.empty()) {
            p = s.pop();
            s2.push(p);
            if (p.left != null) s.push(p.left); //这里是先左再右  (非递归前序是先右再左)
            if (p.right != null) s.push(p.right);
        }
        while (!s2.empty())
            System.out.print(s2.pop().val + " ");
    }

    /**
     * 层级遍历
     * @param root
     */
    static void levelOrder(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            System.out.print(now.val + " ");
            if (now.left != null) queue.add(now.left);
            if (now.right != null) queue.add(now.right);
        }
    }

    public static void mirror(Node node) {
        if(node != null) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
            mirror(node.left);
            mirror(node.right);
        }
    }

    //统计结点个数
    static int count(Node T) {
        if (T == null)
            return 0;
        else
            return count(T.left) + count(T.right) + 1;
    }

    //计算二叉树的深度
    static int depth(Node T) {
        if (T == null)
            return 0;
        return Math.max(depth(T.left), depth(T.right)) + 1;
    }
}
