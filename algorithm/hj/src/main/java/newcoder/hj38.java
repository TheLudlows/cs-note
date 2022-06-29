package newcoder;

import java.util.Scanner;

public class hj38 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double h = Double.parseDouble(scanner.nextLine());
        Double total = 0.0;
        double line = h;
        for (int i = 0; i < 4; i++) {
            total += h;
            line = line / 2.0;
        }
        System.out.println(total + h);
        System.out.println(line / 2.0);
    }
}
