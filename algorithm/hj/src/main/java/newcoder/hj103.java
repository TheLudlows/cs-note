package newcoder;

import java.util.Scanner;

public class hj103 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, longestInc(arr, i));
            }
            System.out.println(max);
        }
    }

    private static int longestInc(int[] arr, int idx) {
        if (idx == 0) {
            return 1;
        }
        int longest = 1;
        for (int i = idx - 1; i >= 0; i--) {
            if (arr[idx] > arr[i]) {
                longest = Math.max(1 + longestInc(arr, i), longest);
            }
        }
        return longest;
    }
}
