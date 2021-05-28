package lc;

import java.util.Scanner;

public class hj22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            int n = max_drink(Integer.parseInt(line));
            if (n > 0) {
                System.out.println(n);
            }
        }

    }

    public static int max_drink(int n) {
        int res = 0;
        while (n > 2) {
            int full = n / 3;
            res += full;
            n = n % 3 + full;
        }
        if (n == 2) {
            res += 1;
        }
        return res;
    }

}
