package leetcode;

import java.util.Arrays;

import static java.awt.SystemColor.text;

public class p1143_max_gg_zixulie {
    int[][] mem;
    public int longestCommonSubsequence(String text1, String text2) {
        mem = new int[text1.length()][text2.length()];
        for(int[] arr : mem) {
            Arrays.fill(arr, -1);
        }
        return longest(text1,text2, text1.length()-1, text2.length()-1);
    }

    private int longest(String text1, String text2, int i, int j) {
        if(i < 0 || j < 0) {
            return 0;
        }
        int ret =  0;
        if(mem[i][j] != -1) {
            return mem[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)) {
            ret = longest(text1, text2, i-1,j-1) + 1;
        }
        ret = Math.max(ret, Math.max(longest(text1,text2, i-1,j), longest(text1,text2,i-1,j)));
        mem[i][j] = ret;
        return ret;
    }
}
