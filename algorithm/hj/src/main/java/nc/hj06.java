package nc;

import java.io.IOException;
import java.util.Scanner;


//todo
public class hj06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long sqrt = (long) Math.sqrt(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= sqrt; ++i) {
            while (num % i == 0) {
                sb.append(i).append(' ');
                num = num / i;
            }
        }
        if(num != 1) {
            sb.append(num);
        }
        if(sb.length() == 0) {
            System.out.println(num);
        } else {
            System.out.println(sb);
        }
    }


}