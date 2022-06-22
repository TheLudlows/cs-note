package lcof;


public class p18_deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre= new ListNode(0);
        pre.next = head;
        ListNode ret = pre;

        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            }
            pre = head;
            head = head.next;
        }
       return ret.next;
    }
}
