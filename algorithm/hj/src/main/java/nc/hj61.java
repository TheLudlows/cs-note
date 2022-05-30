package nc;

import java.util.Scanner;

public class hj61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int ret = s(m, n);
            System.out.println(ret);
        }
    }

    private static int s(int m, int n) {
        if (m == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (n > m) {
            return s(m, m);
        } else {
            return s(m - n, n) + s(m, n-1);
        }
    }


}
