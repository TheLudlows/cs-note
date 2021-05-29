package lc;

import java.util.Scanner;

public class hj65 {

    public static int longgest(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + longgest(s1, s2, i - 1, j - 1);
        } else {
            return Math.max(longgest(s1, s2, i, j - 1), longgest(s1, s2, i - 1, j));
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

    }
}
