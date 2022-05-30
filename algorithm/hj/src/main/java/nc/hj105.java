package nc;

import java.util.Scanner;

public class hj105 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int neg = 0;
        int pos = 0;
        double sum = 0;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n< 0) {
                neg ++;
            } else {
                sum +=n;
                pos++;
            }
        }
        System.out.println(neg);
        if(pos == 0) {
            System.out.println("0.0");
        } else {
            System.out.println(String.format("%.1f", sum * 1.0 / pos));
        }
    }
}
