package newcoder;

import java.util.Scanner;

public class hj99 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int count = 0;
            for(int i=0;i<=n;i++) {
                if( String.valueOf(i*i).endsWith(String.valueOf(i))) {
                    count ++;
                }
            }
            System.out.println(count);
        }
    }
}
