package iv;

/**
 * 给单链表加一
 * 用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。
 *
 * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
 *
 * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 */

//递归啊

class ListNode {
    int n;
    ListNode next;

    public ListNode(int n) {
        this.n = n;
    }
}

public class Test1 {

    static ListNode addOne(ListNode head) {
        ListNode newHead = rev(head);
        ListNode cur = newHead;
        int add = 1;
        ListNode pre = null;
        while (cur != null) {
            cur.n = cur.n + add;
            if (cur.n == 10) {
                cur.n = 0;
            } else {
                add = 0;
                break;
            }
            pre = cur;
        }
        if (add == 1) {
            pre.next = new ListNode(1);
        }
       return rev(newHead);
    }

    static ListNode rev(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode  tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;

        }
        return pre;
    }

    public static void main(String[] args) {
    }
}
