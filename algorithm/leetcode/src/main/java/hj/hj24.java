package hj;

import java.util.Arrays;
import java.util.Scanner;

// dp 最长上升子序列
public class hj24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            String[] strings = scanner.nextLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
            maxLen(arr);
        }
    }

    public static void maxLen(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        int[] dp2 = new int[arr.length];
        // 以i为起始的最长递减子序列
        Arrays.fill(dp2, 1);
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        //System.out.println(Arrays.toString(dp2));
        int max = 0;
        for (int i = 1; i < dp.length - 1; i++) {
            max = Math.max(dp[i] + dp2[i] - 1, max);
        }
        System.out.println(arr.length - max);
    }
}
