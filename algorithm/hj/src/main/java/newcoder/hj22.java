package newcoder;

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

    public static int max_drink(int empty) {
        int res = 0;
        while (empty > 2) {
            int full = empty / 3;
            res += full;
            empty = empty % 3 + full;
        }
        if (empty == 2) {
            res += 1;
        }
        return res;
    }

}
