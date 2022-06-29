package newcoder;

import java.util.Scanner;

public class hj51 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            if(0 < k && k <= n) {
                System.out.println(arr[n-k]);
            } else {
                System.out.println(0);
            }
        }
    }
    static class  ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
