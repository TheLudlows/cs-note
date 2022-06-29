package newcoder;

import java.util.Arrays;
import java.util.Scanner;

public class hj58 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            for(int i=0;i<k;i++) {
                System.out.print(arr[i] + "");
            }
            System.out.println();
        }
    }
}
