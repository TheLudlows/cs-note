import java.util.Scanner;

public class hj69 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int z = scanner.nextInt();

            int[][] arr1 = new int[n][m];
            int[][] arr2 = new int[m][z];

            for (int i = 0; i < n; i++) {
                arr1[i] = new int[m];
                for (int j = 0; j < m; j++) {
                    arr1[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < m; i++) {
                arr2[i] = new int[z];
                for (int j = 0; j < z; j++) {
                    arr2[i][j] = scanner.nextInt();
                }
            }

            int[][] res = new int[n][z];

            for (int i = 0; i < n; i++) {
                res[i] = new int[z];
                for (int j = 0; j < z; j++) {
                    for (int k = 0; k < m; k++) {
                        res[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < z; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
