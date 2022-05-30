package nc;

import java.util.Arrays;
import java.util.Scanner;

public class hj80 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a1 = new int[n];
            for (int i = 0; i < n; i++) {
                a1[i] = scanner.nextInt();
            }
            n = scanner.nextInt();
            int[] a2 = new int[n];
            for (int i = 0; i < n; i++) {
                a2[i] = scanner.nextInt();
            }

            Arrays.sort(a1);
            Arrays.sort(a2);
            int i = 0;
            int j = 0;
            int k = 0;
            int[] arr = new int[a1.length + a2.length];
            while(i < a1.length && j < a2.length) {
                int v;
                if(a1[i] < a2[j]) {
                    v = a1[i];
                    i++;
                } else {
                    v = a2[j];
                    j++;
                }
                if(k > 0 && v == arr[k-1]) {
                    continue;
                }
                arr[k++] = v;
            }

            if(i == a1.length) {
                for(;j < a2.length;j++) {
                    arr[k++] = a2[j];
                }
            } else {
                for(;i < a1.length;i++) {
                    arr[k++] = a1[i];
                }
            }

            for(int z = 0; z< k;z++) {
                System.out.print(arr[z]);
            }
            System.out.println();
        }
    }
}
