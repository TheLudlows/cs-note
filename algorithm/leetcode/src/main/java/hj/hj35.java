package hj;

public class hj35 {
    public static void main(String[] args) {
        int[][] arr = snake(4);
    }

    public static int[][] snake(int n) {
        int[][] arr = new int[n][n];
        int c = 1;
        for (int sum = 0; sum < n; sum++) {
            for (int j = 0; j <= sum; j++) {
                int i = sum - j;
                arr[i][j] = c++;
            }
        }
        return arr;
    }
}
