package nc;

import java.util.Scanner;

public class hj91 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt() + 1;
            int m = scanner.nextInt() + 1;
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                arr[i] = new int[m];
                for (int j = 0; j < m; j++) {
                    if(i == 0) {
                        arr[0][j] = 1;
                    } else if(j == 0) {
                        arr[i][0] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                    }
                }
            }

            System.out.println(arr[n-1][m-1]);
        }
    }
}
