package io.four;

import java.util.LinkedHashMap;

public class RedBlackTree<K extends Comparable<K>, V> {

    private static final byte RED = 1;
    private static final byte BLACK = 0;
    private Node root; // 根节点


    private class Node {
        private byte color;
        private K key; // 存储的key
        private V value; // 存储的值
        private Node leftNode;  // 左节点
        private Node rightNode; // 右节点
        private Node parentNode; // 父节点

        public Node(K key, V value, Node leftNode, Node rightNode, byte color, Node parentNode) {
            super();
            this.key = key;
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.color = color;
            this.parentNode = parentNode;
        }

        @Override
        public String toString() {
            return "{"
                    + "\"key\":" + this.key + ", "
                    + "\"value\":" + "\"" + this.value + "\"" + ", "
                    + "\"color\":" + ((this.color == RED) ? "\"红\"" : "\"黑\"") + ", "
                    + "\"leftNode\":" + this.leftNode + ","
                    + "\"rightNode\":" + this.rightNode + "}";
        }
    }

    public Node get(K key) {
        if (null != key) {
            return find(key, root); // 从根节点开始找
        }
        return null;
    }

    private Node find(K key, Node root) {
        if (null != root) {
            int result = key.compareTo(root.key);
            if (result == 0) {
                return root;
            } else if (result > 0) {
                return find(key, root.rightNode);
            } else {
                return find(key, root.leftNode);
            }
        }
        return null;
    }

    /**
     * 通过中序遍历（按 左，中，右的顺序遍历，），能得到从小到大的 节点顺序
     *
     * @return
     */
    public LinkedHashMap<K, V> inorderTraversal() {
        LinkedHashMap<K, V> nodeMap = new LinkedHashMap<K, V>();
        if (null != root) {
            inorder(root, nodeMap);
        }
        return nodeMap;
    }

    private void inorder(Node root, LinkedHashMap<K, V> nodeMap) {
        if (null != root.leftNode) {
            inorder(root.leftNode, nodeMap);
        }
        nodeMap.put(root.key, root.value);
        if (null != root.rightNode) {
            inorder(root.rightNode, nodeMap);
        }
    }

    /**
     * 对节点 h 左旋转
     * |							|
     * h							m
     * / \     	  	h 左旋转后	   / \
     * a   m						  h	  t
     * / \					 / \
     * k   t					a   k
     */
    private void leftRotation(Node h) {
        Node m = h.rightNode;
        h.rightNode = m.leftNode;
        if (null != m.leftNode) {
            m.leftNode.parentNode = h;
        }
        m.parentNode = h.parentNode;
        if (null == m.parentNode) { // I: 说明 h 原来是根节点，现在将 m 设置为新的根节点
            root = m;
        } else {
            if (h.key.compareTo(h.parentNode.key) < 0) { // II: 说明 h 原来是它父节点的左孩子，现在将 m 设置为新的左孩子
                h.parentNode.leftNode = m;
            } else {
                h.parentNode.rightNode = m; // III: 说明 h 原来是它父节点的右孩子，现在将 m 设置为新的右孩子
            }
        }
        m.leftNode = h;
        h.parentNode = m;
    }

    /**
     * 对节点 m 右旋转
     * |							|
     * m							h
     * / \     	  	m 右旋转后	   / \
     * h   t						  a	  m
     * / \					         / \
     * a   k					        k   t
     */
    private void rightRotation(Node m) {
        Node h = m.leftNode;
        m.leftNode = h.rightNode;
        if (null != h.rightNode) {
            h.rightNode.parentNode = m;
        }
        h.parentNode = m.parentNode;
        if (null == m.parentNode) { // I: 说明 m 原来是根节点，现在将 h 设置为新的根节点
            root = h;
        } else {
            if (m.key.compareTo(m.parentNode.key) < 0) { // II: 说明 m 原来是它父节点的左孩子，现在将 h 设置为新的左孩子
                m.parentNode.leftNode = h;
            } else {
                m.parentNode.rightNode = h; // III: 说明 m 原来是它父节点的右孩子，现在将 h 设置为新的右孩子
            }
        }
        h.rightNode = m;
        m.parentNode = h;
    }

    /**
     * 插入新的节点，如果指定的key已经存在，则更新原来的值
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        Node newNode = new Node(key, value, null, null, RED, null);
        if (null == root) {
            root = newNode;
            root.color = BLACK;
        } else {
            insert(null, root, newNode);
        }
    }

    private void insert(Node parent, Node current, Node newNode) {
        if (null == current) {
            if (newNode.key.compareTo(parent.key) > 0) {
                parent.rightNode = newNode;
            } else {
                parent.leftNode = newNode;
            }
            newNode.parentNode = parent;
            insertFix(newNode); // 插入新节点后 对红黑树进行修复
        } else {
            int result = newNode.key.compareTo(current.key);
            if (result == 0) {
                current.value = newNode.value;
                return;
            }
            parent = current;
            if (result > 0) {
                insert(parent, parent.rightNode, newNode);
            }
            if (result < 0) {
                insert(parent, parent.leftNode, newNode);
            }
        }
    }

    private void insertFix(Node newNode) {
        Node parent = newNode.parentNode;
        if (RED == parent.color) { // 父节点如果是黑节点 则不需要处理
            Node grandfather = parent.parentNode;
            if (parent == grandfather.leftNode) { // 父节点是左节点
                Node uncle = grandfather.rightNode;
                if ((null != uncle) && (RED == uncle.color)) { // case 3: 叔叔节点是红色
                    uncleRedFix(newNode);
                } else { //
                    if (newNode.key.compareTo(parent.key) < 0) { // 当前结点是左结点
                        leftNodeFix(grandfather, parent);//case 5
                    } else {
                        leftRotation(parent);// case 4
                        leftNodeFix(grandfather, newNode); //case 5
                    }
                }
            } else { // 父节点是右节点
                Node uncle = grandfather.leftNode;
                if ((null != uncle) && (RED == uncle.color)) { // case 3: 叔叔节点是红色
                    uncleRedFix(newNode);
                } else {
                    if (newNode.key.compareTo(parent.key) > 0) {
                        rightNodeFix(grandfather, parent);
                    } else {
                        rightRotation(parent);
                        rightNodeFix(grandfather, newNode);
                    }
                }
            }
        }
    }

    /**
     * case 5
     */
    private void leftNodeFix(Node grandfather, Node parent) {
        parent.color = BLACK;
        grandfather.color = RED;
        rightRotation(grandfather);
    }
    /**
     * case 5
     */
    private void rightNodeFix(Node grandfather, Node parent) {
        parent.color = BLACK;
        grandfather.color = RED;
        leftRotation(grandfather);
    }

    /**
     * 处理 case 3: 叔叔节点是红色
     * @param newNode
     */
    private void uncleRedFix(Node newNode) {
        Node parent = newNode.parentNode;
        if ((null != parent) && (RED == parent.color)) {
            Node grandfather = parent.parentNode;
            Node uncle = grandfather.leftNode;
            if (parent == grandfather.leftNode) {
                uncle = grandfather.rightNode;
            }
            parent.color = BLACK;
            uncle.color = BLACK;
            if (root != grandfather) {
                grandfather.color = RED;
                insertFix(grandfather);
            }
        }
    }

    /**
     * 删除 叶子节点 后的修复过程
     */
    private void deleteLeafFix(Node deletedNode) {
        while ((deletedNode != root) && (BLACK == deletedNode.color)) {
            Node parent = deletedNode.parentNode;
            Node brother = getBrother(deletedNode);
            if (deletedNode.key.compareTo(parent.key) > 0) { // 删除的是右叶子节点
                if (RED == brother.color) {
                    brother.color = BLACK;
                    brother.rightNode.color = RED;
                    rightRotation(parent);
                    break;
                } else {
                    if ((null == brother.leftNode) && (null == brother.rightNode)) {
                        brother.color = RED;
                        deletedNode = parent;
                    } else {
                        if ((null != brother.leftNode) && (RED == brother.leftNode.color)) {
                            brother.color = parent.color;
                            parent.color = BLACK;
                            brother.leftNode.color = BLACK;
                            rightRotation(parent);
                            break;
                        } else {
                            brother.rightNode.color = BLACK;
                            brother.color = RED;
                            leftRotation(brother);
                        }
                    }
                }
            } else {// 删除的是左叶子节点
                if (RED == brother.color) { // 如果该兄弟节点是红色的，那么根据红黑树的特性可以得出它的一定有两个黑色的子节点
                    brother.color = BLACK;
                    brother.leftNode.color = RED;
                    leftRotation(parent);
                    break;
                } else {
                    if ((null == brother.leftNode) && (null == brother.rightNode)) { // 兄弟节点是黑色的，且没有子节点
                        brother.color = RED; // 将兄弟节点设为红色，将父节点设为当前节点递归， 直到根节点，或遇到红色节点，
                        deletedNode = parent;
                    } else {
                        if ((null != brother.rightNode) && (RED == brother.rightNode.color)) { // 兄弟节点是黑色的，且有一个右节点（可以断定 右节点是红色的）
                            //  兄弟节点是黑色的，且有两个节点（可以断定 左右节点都是红色的） 这个和情况 1 是一样的
                            brother.color = parent.color;
                            parent.color = BLACK;
                            brother.rightNode.color = BLACK;
                            leftRotation(parent);
                            break;
                        } else { // 兄弟节点是黑色的，且有一个左节点（可以断定 左节点是红色的）
                            brother.leftNode.color = BLACK;
                            brother.color = RED;
                            rightRotation(brother);
                        }
                    }
                }
            }
        }

        deletedNode.color = BLACK;
    }

    private Node getBrother(Node node) {
        if (null == node) {
            return null;
        }
        Node parent = node.parentNode;
        if (null == parent) {
            return null;
        }
        if (node.key.compareTo(parent.key) > 0) {
            return parent.leftNode;
        } else {
            return parent.rightNode;
        }
    }

    public boolean delete(K key) {
        if (null != key) {
            if (null != root) {
                return deleteNode(key, root, null);
            }
        }
        return false;
    }

    private boolean deleteNode(K key, Node current, Node parent) {
        if (null != current) {
            if (key.compareTo(current.key) > 0) {
                return deleteNode(key, current.rightNode, current);
            }
            if (key.compareTo(current.key) < 0) {
                return deleteNode(key, current.leftNode, current);
            }
            if (key.compareTo(current.key) == 0) {
                if ((null != current.leftNode) && (null != current.rightNode)) { //将要删除的节点下有两个子节点
                    delTwoChildrenNode(current);
                    return true;
                } else {
                    if ((null == current.leftNode) && (null == current.rightNode)) { //将要删除的节点没有子节点
                        deleteLeafFix(current);
                        if (current.key.compareTo(parent.key) > 0) {
                            parent.rightNode = null;
                        } else {
                            parent.leftNode = null;
                        }
                        return true;
                    } else { // 将要删除的节点下有一个子节点,
                        dleOneChildNode(current);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void dleOneChildNode(Node delNode) {
        Node replaceNode = (null == delNode.leftNode) ? delNode.rightNode : delNode.leftNode;
        delLeafNode(delNode, replaceNode);
    }

    /**
     * 处理被删除节点有两个子节点的情况
     */
    private void delTwoChildrenNode(Node target) {
        Node replaceNode = successor(target);
        if ((null == replaceNode.rightNode) && (null == replaceNode.leftNode)) {
            delLeafNode(target, replaceNode);
        } else {
            target.key = replaceNode.key;
            target.value = replaceNode.value;
            dleOneChildNode(replaceNode);
        }
    }

    private void delLeafNode(Node target, Node replaceNode) {
        target.key = replaceNode.key;
        target.value = replaceNode.value;
        deleteLeafFix(replaceNode);
        if (replaceNode == replaceNode.parentNode.rightNode) {
            replaceNode.parentNode.rightNode = null;
        } else {
            replaceNode.parentNode.leftNode = null;
        }
    }

    /**
     * 找后继结点。即查找"红黑树中数据值大于该结点"的"最小结点"
     */
    private Node successor(Node node) {
        if (node == null) {
            return null;
        }
        if (null != node.rightNode) { // 获取 后继节点
            Node p = node.rightNode;
            while (null != p.leftNode) {
                p = p.leftNode;
            }
            return p;
        } else {
            Node p = node.parentNode;
            Node ch = node;
            while (p != null && ch == p.rightNode) {
                ch = p;
                p = p.parentNode;
            }
            return p;
        }
    }
    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {

        RedBlackTree<Integer, String> bst = new RedBlackTree<Integer, String>();

        bst.put(100, "v100");
        bst.put(50, "v50");
        bst.put(150, "v150");
        bst.put(20, "v20");
        bst.put(85, "v85");
        bst.put(10, "v10");
        bst.put(15, "a15");
        bst.put(75, "v75");
        bst.put(95, "v95");
        bst.put(65, "v65");
        bst.put(76, "v76");
        bst.put(60, "v60");
        bst.put(66, "v66");
        bst.put(61, "v61");


        // 当前节点是左节点 的 5中情况
        //bst.delete(15); // 1. 兄弟节点是黑色的，且有一个右节点（可以断定 右节点是红色的）

        // 2. 兄弟节点是黑色的，且有一个左节点（可以断定 左节点是红色的
        //bst.put(140, "v140");
        //bst.delete(95);

        // 4. 兄弟节点是黑色的，且没有子节点
        //bst.delete(66);

        //5. 如果该兄弟节点是红色的，那么根据红黑树的特性可以得出它的一定有两个黑色的子节点
        //bst.delete(95);
        //bst.delete(15);


        System.out.println(bst.getRoot());
    }
}
