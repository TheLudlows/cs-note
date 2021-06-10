package lc;

public class p0092_reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 头插法
        int i = 0;
        ListNode fuzzNode = new ListNode(-1);
        fuzzNode.next = head;
        ListNode pre = fuzzNode;
        while (i < left - 1) {
            pre = pre.next;
            i++;
        }
        // 第一个需要翻转的节点，最后会变为翻转尾节点，
        ListNode tail = pre.next;

        for (int k = left; k < right; k++) {
            ListNode revNode = tail.next; // 翻转的节点，第二个开始
            tail.next = revNode.next; // 将需要翻转的节点的移除，并将后面的节点加载尾部。
            revNode.next = pre.next; // 翻转的节点设置后继节点
            pre.next = revNode;// 插入该节点
        }
        return fuzzNode.next;
    }
}
