package lcof2;

import lcof.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class p26 {
    public void reorderList(ListNode head) {

        Deque<ListNode> deque = new ArrayDeque();
        while(head != null) {
            deque.offerLast(head);
            head = head.next;
        }

        while(!deque.isEmpty()) {
            ListNode left = deque.pollFirst();
            ListNode right =  deque.pollLast();
            left.next = right;
            if(right != null) {
                right.next = deque.peekFirst();
            }
        }
    }
}
