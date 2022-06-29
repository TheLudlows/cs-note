package newcoder;

import java.util.Scanner;

public class hj35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] arr = snake(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] snake(int n) {
        int[][] arr = new int[n][n];
        int c = 1;
        for(int k = 0;k<n;k++) {
            for(int i=k;i>=0;i--) {
                int j = k - i;
                arr[i][j] = c++;
            }
        }
        return arr;
    }
}
