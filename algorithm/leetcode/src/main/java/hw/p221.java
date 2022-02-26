package hw;

public class p221 {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, findMax(i, j, matrix));
                }
            }
        }
        return max;
    }

    private int findMax(int i, int j, char[][] matrix) {
        int startI = i;
        int startJ = j;
        for (; i < matrix.length; i++) {
            for (; j < matrix[0].length; j++) {
                if (matrix[i][j] != '1') {
                    System.out.println(i + " " + j + " " + startI + " " + startJ );
                    int n = Math.min(i - startI, j - startJ);
                    return n * n;
                }
            }
        }
        int n = Math.min(i - startI, j - startJ);
        return n * n;
    }
}
