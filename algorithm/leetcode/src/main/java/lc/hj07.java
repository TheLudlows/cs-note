package lc;

import java.util.Scanner;

public class hj07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.trim();
        double d = Double.parseDouble(s);
        System.out.println(Math.round(d));
    }
}
