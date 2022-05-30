package nc;

import java.util.Scanner;

public class hj76 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            int m = n * n * n;
            int left = 1;
            int right = 1 + (n - 1) * 2;
            int sum = (left + right) * n / 2;
            while (left <= m) {
                if (sum == m) {
                    print(left, right);
                    break;
                }
                sum += right + 2;
                sum -= left;
                right = right + 2;
                left = left + 2;
            }
        }
    }

    private static void print(int i, int j) {
        StringBuilder builder = new StringBuilder();
        while (i <= j) {
            builder.append(i);
            builder.append("+");
            i += 2;
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder);
    }
}
