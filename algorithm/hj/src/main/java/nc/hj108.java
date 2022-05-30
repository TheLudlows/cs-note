package nc;

import java.util.Scanner;

public class hj108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n =scanner.nextInt();
            int m = scanner.nextInt();
            int total = n * m;
            int act = 1;
            for(int i=2;i<=m & i <= n;i++) {
                while(n % i == 0 && m % i == 0) {
                    n = n/i;
                    m = m/i;
                    act = act * i;
                }
            }
            System.out.println(total / act);
        }
    }
}
