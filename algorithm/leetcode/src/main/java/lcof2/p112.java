package lcof2;

public class p112 {
    int[][] mem;
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        mem = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                max = Math.max(max, func(matrix, i, j));
            }
        }
        return max;
    }

    private int func(int[][] matrix, int i, int j) {
        if(mem[i][j] !=0) {
            return mem[i][j];
        }
        int maxLen = 1;
        int v = matrix[i][j];
        // 上
        if(i-1 >= 0 && matrix[i-1][j] > v) {
            maxLen = Math.max(func(matrix,i-1, j) + 1, maxLen);
        }
        // 下
        if(i+1 < matrix.length && matrix[i+1][j] > v) {
            maxLen = Math.max(func(matrix,i+1, j) + 1, maxLen);
        }
        // 左
        if(j-1 >= 0 && matrix[i][j-1] > v) {
            maxLen = Math.max(func(matrix,i, j-1) + 1, maxLen);
        }
        // 右
        if(j+1 < matrix[0].length && matrix[i][j+1] > v) {
            maxLen = Math.max(func(matrix,i, j+1) + 1, maxLen);
        }
        mem[i][j] = maxLen;
        return maxLen;

    }
}
