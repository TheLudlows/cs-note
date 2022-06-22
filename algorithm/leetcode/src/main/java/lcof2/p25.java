package lcof2;

import lcof.ListNode;

import java.util.Stack;

public class p25 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = new ListNode(0);
        int pre = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || pre != 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int v = a + b + pre;
            pre = v / 10;
            v = v % 10;

            ListNode node = new ListNode(v);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }
}
