import java.util.Scanner;

public class hj86 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int max = 0;
            int add = 0;
            while(n > 0) {
                if((n & 1) == 1) {
                    add++;
                } else {
                    add = 0;
                }
                n = n >> 1;
                max = Math.max(max, add);
            }
            System.out.println(max);
        }
    }
}
