package newcoder;

import java.util.Scanner;

public class hj56 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int total = 0;
            for (int i = 1; i <= n; i++) {
                if (isPerfect(i)) {
                    total++;
                }
            }
            System.out.println(total);
        }
    }

    private static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if(n % i == 0) {
                sum +=i;
            }
        }
        return sum == n;
    }
}
