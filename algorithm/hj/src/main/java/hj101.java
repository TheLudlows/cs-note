import java.util.Arrays;
import java.util.Scanner;

public class hj101 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int sort = scanner.nextInt();

            Arrays.sort(arr);

            if (sort == 0) {
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();

        }
    }
}
