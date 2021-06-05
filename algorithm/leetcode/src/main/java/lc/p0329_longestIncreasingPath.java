package lc;

public class p0329_longestIncreasingPath {
    static int[][] memo;
    public static int longestIncreasingPath(int[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(find(matrix, i, j), max);
            }
        }
        return max;
    }

    private static int find(int[][] matrix, int i, int j) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int top = 0;
        int left = 0;
        int bottom = 0;
        int right = 0;
        if (i > 0) {
            if (matrix[i][j] < matrix[i - 1][j]) {
                top = 1 + find(matrix, i - 1, j);
            }
        }
        if (j > 0) {
            if (matrix[i][j] < matrix[i][j - 1]) {
                left = 1 + find(matrix, i, j - 1);
            }
        }
        if (i < matrix.length - 1) {
            if (matrix[i][j] < matrix[i + 1][j]) {
                bottom = 1 + find(matrix, i + 1, j);
            }
        }
        if (j < matrix[0].length - 1) {
            if (matrix[i][j] < matrix[i][j + 1]) {
                right = 1 + find(matrix, i, j + 1);
            }
        }
        int ret = Math.max(1, Math.max(Math.max(left, right), Math.max(bottom, top)));
        memo[i][j] = ret;
        return ret;
    }
}
