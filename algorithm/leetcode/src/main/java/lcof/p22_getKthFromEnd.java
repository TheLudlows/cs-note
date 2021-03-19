package lcof;


public class p22_getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while(k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast!= null) {
            slow = slow.next;
            fast = fast.next;
        }
       return slow;
    }
}
