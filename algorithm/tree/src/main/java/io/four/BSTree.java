package io.four;

public class BSTree<E extends Comparable> {

    public class Node {
        public E e;
        public Node left, right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        public int degree() {
            int d = 0;
            if (left != null) d++;
            if (right != null) d++;
            return d;
        }
    }

    private Node root;

    public BSTree add(E e) {
        if (root == null) {
            root = new Node(e);
            return this;
        }
        add(root, e);
        return this;
    }

    private void add(Node node, E e) {
        int n = node.e.compareTo(e);
        if (n > 0) {
            if (node.left == null) {
                node.left = new Node(e);
            } else {
                add(node.left, e);
            }
        } else if (n < 0) {
            if (node.right == null) {
                node.right = new Node(e);
            } else {
                add(node.right, e);
            }
        }
        // 等于0不处理
    }

    public Node search(E e) {
        return search(root, e);
    }

    private Node search(Node node, E e) {
        if (node == null) {
            return null;
        }
        int n = node.e.compareTo(e);
        if (n == 0) {
            return node;
        } else if (n > 0) {
            return search(node.left, e);
        } else {
            return search(node.right, e);
        }
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) { // only have right child or leaf
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            }

            Node successor = min(node.right); //找到右子树的最小结点
            successor.right = removeMin(node.right); //将successor.right设置成 原先结点node的右子树移除 successor之后的树
            successor.left = node.left;

            //remove node
            node.left = node.right = null;
            return successor; //返回新树的根
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

    public void removeMin() {
        root = removeMin(root);
    }

    private Node removeMin(Node node) {
        if (node.left == null) { //node is min
            Node rightNode = node.right;
            node.right = null;//cut
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * test
     */
    public static void main(String[] args) {
        BSTree<Integer> bsTree = new BSTree();
        bsTree.add(10).add(5).add(13).add(3).add(6);
        bsTree.remove(10);
        System.out.println(bsTree.search(13).e);
    }
}
