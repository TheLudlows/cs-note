package hj;

import java.util.Arrays;
import java.util.Scanner;

public class hj32 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            //int n = max_rev(line);
            //System.out.println(n);
        }
    }

    public static String max_rev(String s) {
        if(s.length() <= 0) {
            return s;
        }
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        int max = 0;
        int start = 0;
        char[] arr = s.toCharArray();
        for (int j = 1; j < dp.length; j++) {
            for (int i = 0; i < j; i++) {
                if (arr[i] == arr[j]) {
                     if (j - i == 1 || dp[i + 1][j - 1] > 0) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    dp[i][j] = 0;
                }
                if(dp[i][j] > max) {
                    max = dp[i][j];
                    start = i;
                }
            }
        }
        System.out.println(max);
        return s.substring(start, start+max);
        //return max;
    }

}
