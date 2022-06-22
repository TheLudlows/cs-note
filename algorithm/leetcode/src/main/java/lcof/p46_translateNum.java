package lcof;

public class p46_translateNum {
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int n = Integer.parseInt(s.substring(i-2,i));
            char first_char = s.charAt(i-2);
            System.out.println(n);
            dp[i] = dp[i-1];
            if(n < 26 && first_char != '0' ) {
               dp[i] +=dp[i-2];
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        System.out.println(translateNum(102));

    }
}
