import java.util.Scanner;

public class hj60 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int diff = Integer.MAX_VALUE;
            int rec = 0;
            for (int i = 2; i <= n / 2; i++) {
                int j = n - i;
                if (isPrime(i) && isPrime(j)) {
                    if (Math.abs(i - j) < diff) {
                        rec = i;
                    }
                }
            }

            System.out.println(rec);
            System.out.println((n - rec));
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
