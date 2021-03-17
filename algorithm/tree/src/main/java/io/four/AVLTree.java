package io.four;

public class AVLTree<E extends Comparable<E>> {
    public Node root;

    private class Node {
        public E e;
        public Node left, right;
        public int height;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
            height = 1;
        }

        public int degree() {
            int d = 0;
            if (left != null) d++;
            if (right != null) d++;
            return d;
        }

    }

    //min
    public E min() {
        return min(root).e;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public int height(Node node) {
        return node == null ? 0 : node.height;
    }

    public int balanceFactor(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    public Node turnRight(Node node) {
        Node left = node.left;
        Node leftRight = left.right;
        left.right = node;
        node.left = leftRight;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        left.height = 1 + Math.max(height(left.left), height(left.right));
        return left;
    }

    public Node turnLeft(Node node) {
        Node right = node.right;
        Node rightLeft = right.left;
        right.left = node;
        node.right = rightLeft;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        right.height = 1 + Math.max(height(right.left), height(right.right));
        return right;
    }

    public AVLTree<E> add(E e) {
        if (root == null) {
            root = new Node(e);
            return this;
        }
        root = add(root, e);
        return this;
    }

    private Node add(Node node, E e) {
        if (node == null) {
            return new Node(e);
        }
        int n = node.e.compareTo(e);
        if (n > 0) {
            node.left = add(node.left, e);
        } else if (n < 0) {
            node.right = add(node.right, e);
        }
        // 调整
        return aJust(node);
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) return null;
        Node retNode;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            retNode = node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            retNode = node;
        } else {
            if (node.left == null) { // only have right child or leaf
                Node rightNode = node.right;
                node.right = null;
                retNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                retNode = leftNode;
            } else {
                Node successor = min(node.right); //找到右子树的最小结点
                successor.right = remove(node.right, e); //将successor.right设置成 原先结点node的右子树移除 successor之后的树
                successor.left = node.left;
                //remove node
                node.left = node.right = null;
                retNode = successor; //返回新树的根
            }
        }
        if (retNode == null) {
            return null;
        }
        return aJust(retNode);
    }


    private Node aJust(Node node) {
        // 跟新高度
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int bf = balanceFactor(node);
        int rBf = balanceFactor(node.right);
        int LBf = balanceFactor(node.left);

        if (bf > 1 && LBf >= 0) {//LL
            return turnRight(node);
        } else if (bf > 1 && LBf < 0) {//LR
            node.left = turnLeft(node.left);
            return turnRight(node);
        } else if (bf < -1 && rBf < 0) {//RR
            return turnLeft(node);
        } else if (bf < -1 && rBf > 0) { //RL
            node.right = turnRight(node.right);
            return turnLeft(node);
        }
        return node;
    }

    private boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) { // self is balance and child is balance
        if (node == null)
            return true; // empty tree is a balance tree
        if (Math.abs(balanceFactor(node)) > 1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.add(1).add(2).add(3);
        //avlTree.remove(1);
        System.out.println(avlTree.isBalanced());
    }
}
