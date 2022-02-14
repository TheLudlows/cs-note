import java.util.Scanner;

public class hj48 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int headVal = scanner.nextInt();
            ListNode head = new ListNode(headVal);
            for(int i=1;i<n;i++) {
                int val = scanner.nextInt();
                int afterVal = scanner.nextInt();
                insertVal(head, val, afterVal);
            }
            int delVal = scanner.nextInt();

            delVal(head, delVal);

            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }
    }

    public static void insertVal(ListNode cur, int val, int afterVal) {
        while(cur.val != afterVal) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        ListNode newNode = new ListNode(val);
        newNode.next = next;
        cur.next = newNode;
    }

    public static ListNode delVal(ListNode cur, int val) {
        ListNode head = new ListNode(-1);
        head.next = cur;
        cur = head;

        while(cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if(cur.next != null && cur.next.val == val) {
            cur.next = cur.next.next;
        }
        return head.next;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
