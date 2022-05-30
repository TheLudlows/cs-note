package nc;

import java.util.Scanner;

public class hj100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int end = 2 + (n-1) * 3;
            int out = (2 + end ) * n / 2;
            System.out.println(out);
        }
    }
}
