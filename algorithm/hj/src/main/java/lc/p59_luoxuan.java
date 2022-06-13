package lc;

public class p59_luoxuan {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int x = 1;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bot = n - 1;

        while (left <= right && bot >= top) {

            for (int i = left; i <= right; i++) {
                arr[top][i] = x++;
            }
            top++;

            for (int i = top; i <= bot; i++) {
                arr[i][right] = x++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                arr[bot][i] = x++;
            }
            bot--;
            for (int i = bot; i >= top; i--) {
                arr[i][left] = x++;
            }
            left++;
        }
        return arr;
    }
}
