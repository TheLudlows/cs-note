package lcof;

import java.util.List;

public class p18_deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode res = head;
        ListNode pre = null;
        while (head != null) {
            if (head.val == val) {
                break;
            }
            pre = head;
            head = head.next;
        }
        if (pre == null) {
            res = head.next;
        } else {
            pre.next = head.next;
        }
        return res;
    }
}
