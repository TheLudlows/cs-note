package leetcode;

class solution {

    int[][] mem;
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        mem = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, longest(matrix, i, j));
            }
        }
        return max;
    }

    private int longest(int[][] matrix, int i, int j) {
        if(mem[i][j] != 0) {
            return mem[i][j];
        }
        int n = matrix[i][j];
        // 上
        int maxSub = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > n) {
            maxSub = Math.max(maxSub, longest(matrix, i - 1, j));
        }
        // 下
        if (i + 1 < matrix.length && matrix[i + 1][j] > n) {
            maxSub = Math.max(maxSub, longest(matrix, i + 1, j));
        }
        // 左
        if (j -1 >= 0 && matrix[i][j-1] > n) {
            maxSub = Math.max(maxSub, longest(matrix, i, j-1));
        }
        // 又
        if (j + 1 < matrix[0].length && matrix[i][j+1] > n) {
            maxSub = Math.max(maxSub, longest(matrix, i, j+1));
        }
        mem[i][j] = maxSub + 1;
        return maxSub + 1;
    }
}
