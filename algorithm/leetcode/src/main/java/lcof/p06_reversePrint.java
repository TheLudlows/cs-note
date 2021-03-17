package lcof;

import java.util.Stack;

public class p06_reversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }
        return arr;
    }
}
