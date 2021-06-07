package lc;

import java.util.Arrays;

public class p0072_minDistance {

    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return dis(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    // 如果某个为0，那么两者的编辑距离就是剩余的那个的长度+1
    public int dis(String w1, int i, String w2, int j) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int ret;
        if (w1.charAt(i) == w2.charAt(j)) {
            ret = dis(w1, i - 1, w2, j - 1);
        } else {
            ret = 1 + Math.min(dis(w1, i, w2, j - 1), Math.min(dis(w1, i - 1, w2, j), dis(w1, i - 1, w2, j - 1)));
        }
        memo[i][j] = ret;
        return ret;

    }
}
