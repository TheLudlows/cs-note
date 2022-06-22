package lcof;

import java.util.HashMap;
import java.util.Map;


/**
 * 先正常遍历next 指针，同时建立old -> new的map对象，然后构建random指针。
 */
public class p35_copylist {
    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();

        Node newHead = new Node(-1);
        Node cur = newHead;
        Node oldCur = head;
        while (oldCur != null) {
            cur.next = new Node(oldCur.val);
            cur = cur.next;
            map.put(oldCur, cur);// old -> new
            oldCur = oldCur.next;
        }
        oldCur = head;
        while (oldCur != null) {
            Node newNode = map.get(oldCur);
            Node random = oldCur.random;
            Node oldRandom = map.get(random);
            newNode.random = oldRandom;

            oldCur = oldCur.next;
        }

        return newHead.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 * lass Solution {
 *     // 1. 中序，递归，来自解题大佬
 *     Node pre, head;
 *     public Node treeToDoublyList(Node root) {
 *         // 边界值
 *         if(root == null) return null;
 *         dfs(root);
 *
 *         // 题目要求头尾连接
 *         head.left = pre;
 *         pre.right = head;
 *         // 返回头节点
 *         return head;
 *     }
 *     void dfs(Node cur) {
 *         // 递归结束条件
 *         if(cur == null) return;
 *         dfs(cur.left);
 *         // 如果pre为空，就说明是第一个节点，头结点，然后用head保存头结点，用于之后的返回
 *         if (pre == null) head = cur;
 *         // 如果不为空，那就说明是中间的节点。并且pre保存的是上一个节点，
 *         // 让上一个节点的右指针指向当前节点
 *         else if (pre != null) pre.right = cur;
 *         // 再让当前节点的左指针指向父节点，也就连成了双向链表
 *         cur.left = pre;
 *         // 保存当前节点，用于下层递归创建
 *         pre = cur;
 *         dfs(cur.right);
 *     }
 */