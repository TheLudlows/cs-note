import java.util.Scanner;

public class hj28 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int sum = arr[i] + arr[j];
                    if(isZhiShu(sum)) {
                        count ++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isZhiShu(int n) {
        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % sqrt == 0) {
                return false;
            }
        }
        return true;
    }
}
