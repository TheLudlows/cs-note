import java.util.Scanner;

public class hj71 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine().toLowerCase();
            String s2 = scanner.nextLine().toLowerCase();
            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new boolean[s2.length() + 1];
            }
            if (s1.startsWith("*")) {
                dp[1][0] = true;
            }
            dp[0][0] = true;
            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    char c1 = s1.charAt(i - 1);
                    char c2 = s2.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        if (c1 == '?') {
                            dp[i][j] = dp[i - 1][j - 1];
                        } else if (c1 == '*') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j-1] || dp[i-1][j-1];
                        }
                    }
                }
            }
            System.out.println(dp[s1.length()][s2.length()]);
        }
    }

}
