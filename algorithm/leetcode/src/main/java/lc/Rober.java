package lc;

import java.util.Scanner;

public class Rober {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");

        int[] arr = new int[str.length];
        for(int i=0;i< arr.length;i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++) {
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
        }
        System.out.println(dp[arr.length-1]);
    }
}
