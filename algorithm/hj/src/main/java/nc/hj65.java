package nc;

import java.util.Arrays;
import java.util.Scanner;

public class hj65 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            if(s2.length() < s1.length()) {
                String temp  = s1;
                s1 = s2;
                s2 =temp;
            }
            int start = 0;
            int end = 0;
            int max = 0;
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = i; j <= s1.length(); j++) {
                    String sub = s1.substring(i, j);
                    if (s2.contains(sub)) {
                        if (max < sub.length()) {
                            start = i;
                            end = j;
                            max = sub.length();
                        }
                    }
                }
            }
            System.out.println(s1.substring(start, end));
        }
    }

    class Solution1 {

        public int longestCommonSubsequence(String text1, String text2) {
            int[][] arr = new int[text1.length()][text2.length()];
            for (int i = 0; i < text1.length(); i++) {
                arr[i] = new int[text2.length()];
                Arrays.fill(arr[i], -1);
            }
            return longgest(text1, text2, text1.length() - 1, text2.length() - 1, arr);
        }

        public int longgest(String s1, String s2, int i, int j, int[][] arr) {
            if (i < 0 || j < 0) {
                return 0;
            }
            if (arr[i][j] != -1) {
                return arr[i][j];
            }
            int ret;
            if (s1.charAt(i) == s2.charAt(j)) {
                ret = 1 + longgest(s1, s2, i - 1, j - 1, arr);
            } else {
                ret = Math.max(longgest(s1, s2, i, j - 1, arr), longgest(s1, s2, i - 1, j, arr));
            }
            arr[i][j] = ret;
            return ret;

        }
    }

    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int max = 0;
            int[][] mem = new int[nums1.length][nums2.length];
            for (int i = 0; i < nums1.length; i++) {
                mem[i] = new int[nums2.length];
                Arrays.fill(mem[i], -1);
            }
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    max = Math.max(max, longestCommonSubArr(nums1, nums2, i, j, mem));
                }
            }
            return max;
        }

        private int longestCommonSubArr(int[] nums1, int[] nums2, int i, int j, int[][] mem) {
            if (i < 0 || j < 0) {
                return 0;
            }
            if (mem[i][j] != -1) {
                return mem[i][j];
            }
            int ret;
            if (nums2[j] == nums1[i]) {
                ret = 1 + longestCommonSubArr(nums1, nums2, i - 1, j - 1, mem);
            } else {
                ret = 0;
            }
            mem[i][j] = ret;
            return ret;
        }
    }
}
