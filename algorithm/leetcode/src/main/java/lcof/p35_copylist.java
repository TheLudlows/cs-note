package lcof;

import java.util.HashMap;
import java.util.Map;

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