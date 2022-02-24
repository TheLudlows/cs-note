package lc;

import java.util.Arrays;
import java.util.Scanner;

//恰好装满背包：则初始化时，DP[0]=0, 其他的DP[1…..V]均设为负的无穷大。
//
//无须恰好装满背包：则初始化时，DP[1…..V]全部设为0；
public class Package {

    /**
     * 01背包
     */
    public static int pk01(int v, int n, int[] ws, int[] vs) {
        int[][] dp = new int[n + 1][v + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= ws[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - ws[i]] + vs[i]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][v];
    }

    public static int pk01_2(int v, int n, int[] ws, int[] vs) {
        int[] dp = new int[v + 1];
        dp[v] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = v; j > 0; j--) {
                if (j >= ws[i]) {
                    dp[j] = Math.max(dp[j], dp[j - ws[i]] + vs[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[v];
    }


    /**
     * 完全背包
     */
    public static int pkFull(int v, int n, int[] ws, int[] vs) {
        int[][] dp = new int[n + 1][v + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= ws[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - ws[i]] + vs[i]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n][v];
    }

    public static int pkFull2(int v, int n, int[] ws, int[] vs) {
        int[] dp = new int[v + 1];
        dp[v] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                if (j >= ws[i]) {
                    dp[j] = Math.max(dp[j], dp[j - ws[i]] + vs[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[v];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int v = scanner.nextInt();
        int[] ws = new int[n + 1];
        int[] vs = new int[n + 1];

        for (int i = 0; i < n; i++) {
            ws[i + 1] = scanner.nextInt();
            vs[i + 1] = scanner.nextInt();

        }
        int res = pk01(v, n, ws, vs);
        System.out.println(res);
    }
}
