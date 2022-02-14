import java.io.IOException;
import java.util.Scanner;


//todo
public class hj06 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long sqrt = (long) Math.sqrt(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                sb.append(i).append(" ");
                num = num / i;
            }
        }
        if(sb.length() == 0) {
            System.out.println(num);
        } else {
            System.out.println(sb);
        }
    }

}