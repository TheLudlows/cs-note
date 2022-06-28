package lcof2;

import lc.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class p78 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(Comparator.comparingInt(e -> e.val));
        for(ListNode node : lists) {
            if(node == null) {
                continue;
            }
            queue.offer(node);
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(queue.size() > 0) {
            ListNode tmp = queue.poll();
            if(tmp.next != null) {
                queue.offer(tmp.next);
            }
            cur.next = tmp;
            cur = cur.next;
        }
        return head.next;
    }
}
