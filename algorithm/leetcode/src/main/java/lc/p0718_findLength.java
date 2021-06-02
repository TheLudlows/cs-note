package lc;

public class p0718_findLength {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            if (nums2[0] == nums1[i]) {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
            }
        }
        int max = 0;
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;


    }
}
