package lc;


import java.util.*;

public class Paths {
    static boolean[][] block ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int q = Integer.parseInt(str[2]);
        block = new boolean[n][m];
        for (int i = 0; i < q; i++) {
            String[] arrs = scanner.nextLine().split(" ");
            block[Integer.parseInt(arrs[0])-1][Integer.parseInt(arrs[1])-1] = true;
        }

        long[][] dp = new long[n][m];
        for(int i=1;i<n;i++) {
            if(dp[i-1][0] == -1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }

        for(int i=1;i<m;i++) {
            if(block[0][i-1] || block[0][i]) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        for(int i =1;i<n;i++) {
            for(int j = 1;j<m;j++) {
                if(block[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (block[i-1][j]? 0 : dp[i-1][j]) + (block[i][j-1]?0 : dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n-1][m-1]);
    }

}
