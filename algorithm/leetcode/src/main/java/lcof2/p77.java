package lcof2;

import lc.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class p77 {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(Comparator.comparingInt(e -> e.val));

        while(head != null) {
            queue.offer(head);
            head = head.next;
        }

        head = new ListNode(0);
        ListNode cur = head;
        while(!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return head.next;
    }
}
